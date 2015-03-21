package com.bluedigm.adwsb.service;

import java.util.List;

import com.bluedigm.adwsb.domain.Group;
import com.bluedigm.adwsb.domain.Member;

public interface MemberService {

	List<Group> listGroup();

	Group getGroup(Integer id);

	Integer createGroup(Group group);

	void updateGroup(Group group);

	void deleteGroup(Integer id);

	List<Member> listMember();

	Member getMember(String id);

	void createMember(Member member);

	void updateMember(Member member);

	void deleteMember(String id);

}
