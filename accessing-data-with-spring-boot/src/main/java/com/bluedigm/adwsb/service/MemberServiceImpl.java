package com.bluedigm.adwsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluedigm.adwsb.BaseComponent;
import com.bluedigm.adwsb.domain.Email;
import com.bluedigm.adwsb.domain.Group;
import com.bluedigm.adwsb.domain.Member;
import com.bluedigm.adwsb.domain.Profile;
import com.bluedigm.adwsb.domain.Project;
import com.bluedigm.adwsb.repository.EmailRepository;
import com.bluedigm.adwsb.repository.GroupRepository;
import com.bluedigm.adwsb.repository.MemberRepository;
import com.bluedigm.adwsb.repository.ProfileRepository;
import com.bluedigm.adwsb.repository.ProjectRepository;

@Service
@Transactional
public class MemberServiceImpl extends BaseComponent implements MemberService {

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private EmailRepository emailRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public List<Group> listGroup() {
		return groupRepository.findAll();
	}

	@Override
	public Group getGroup(Integer id) {
		return groupRepository.findOne(id);
	}

	@Override
	public Integer createGroup(Group group) {
		Group saved = groupRepository.save(group);

		return saved.getId();
	}

	@Override
	public void updateGroup(Group group) {
		groupRepository.save(group);
	}

	@Override
	public void deleteGroup(Integer id) {
		groupRepository.delete(id);
	}

	@Override
	public List<Member> listMember() {
		return memberRepository.findAll();
	}

	@Override
	public Member getMember(String id) {
		Member member = memberRepository.findOne(id);

		if (member != null) {
			Profile profile = profileRepository.findOne(member.getId());
			member.setProfile(profile);
		}

		return member;
	}

	@Override
	public void createMember(Member member) {
		saveMember(member);
	}

	@Override
	public void updateMember(Member member) {
		saveMember(member);
	}

	@Override
	public void deleteMember(String id) {
		Member member = getMember(id);
		
		if (member != null) {
			memberRepository.delete(id);
		}
	}

	private void saveMember(Member member) {
		List<Email> emails = member.getEmails();
		if (emails != null) {
			emailRepository.save(emails);
		}

		memberRepository.save(member);

		Profile profile = member.getProfile();
		if (profile != null) {
			List<Project> projects = profile.getProjects();
			if (projects != null) {
				projectRepository.save(projects);
			}

			profileRepository.save(profile);
		}
	}

}
