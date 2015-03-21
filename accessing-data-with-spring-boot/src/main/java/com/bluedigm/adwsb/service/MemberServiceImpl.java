package com.bluedigm.adwsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedigm.adwsb.BaseComponent;
import com.bluedigm.adwsb.domain.Email;
import com.bluedigm.adwsb.domain.Group;
import com.bluedigm.adwsb.domain.Member;
import com.bluedigm.adwsb.repository.EmailRepository;
import com.bluedigm.adwsb.repository.GroupRepository;
import com.bluedigm.adwsb.repository.MemberRepository;

@Service
public class MemberServiceImpl extends BaseComponent implements MemberService {

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private EmailRepository emailRepository;

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
		return memberRepository.findOne(id);
	}

	@Override
	public void createMember(Member member) {
		if (member.getEmails() != null) {
			for (Email email : member.getEmails()) {
				emailRepository.save(email);
			}
		}
		memberRepository.save(member);
	}

	@Override
	public void updateMember(Member member) {
		if (member.getEmails() != null) {
			for (Email email : member.getEmails()) {
				emailRepository.save(email);
			}
		}
		memberRepository.save(member);
	}

	@Override
	public void deleteMember(String id) {
		memberRepository.delete(id);
	}

}
