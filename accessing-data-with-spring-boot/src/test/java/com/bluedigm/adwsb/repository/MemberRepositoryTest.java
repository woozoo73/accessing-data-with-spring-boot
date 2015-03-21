package com.bluedigm.adwsb.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bluedigm.adwsb.AbstractSpringTest;
import com.bluedigm.adwsb.domain.Email;
import com.bluedigm.adwsb.domain.Group;
import com.bluedigm.adwsb.domain.Member;

public class MemberRepositoryTest extends AbstractSpringTest {

	@Autowired
	GroupRepository groupRepository;

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	EmailRepository emailRepository;

	Group savedGroup;

	@Before
	public void setUp() throws Exception {
		Group group = new Group();
		group.setName("member-group");

		savedGroup = groupRepository.save(group);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Member member = new Member();
		member.setId(UUID.randomUUID().toString());
		member.setName("test-user");
		member.setPassword("1234");

		List<Email> emails = new ArrayList<Email>();

		Email email0 = new Email();
		email0.setValue("email0@bluedigm.com");
		email0 = emailRepository.save(email0);
		emails.add(email0);

		Email email1 = new Email();
		email1.setValue("email1@bluedigm.com");
		email1 = emailRepository.save(email1);
		emails.add(email1);

		member.setEmails(emails);

		member.setGroup(savedGroup);

		Member savedMember = memberRepository.save(member);

		logger.debug("savedMember={}", savedMember);
		assertNotNull(savedMember);

		Member findedMember = memberRepository.findOne(savedMember.getId());

		assertNotNull(findedMember);
		assertEquals(savedGroup.getId(), savedMember.getGroup().getId());
		assertEquals(2, savedMember.getEmails().size());
	}

}
