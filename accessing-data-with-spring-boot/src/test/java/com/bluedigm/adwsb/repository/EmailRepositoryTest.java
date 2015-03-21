package com.bluedigm.adwsb.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bluedigm.adwsb.AbstractSpringTest;
import com.bluedigm.adwsb.domain.Email;

public class EmailRepositoryTest extends AbstractSpringTest {

	@Autowired
	EmailRepository emailRepository;

	@Test
	public void test() {
		Email email = new Email();
		email.setValue("test.email@bluedigm.com");

		Email savedEmail = emailRepository.save(email);

		logger.debug("savedEmail={}", savedEmail);
		assertNotNull(savedEmail);

		Email findedEmail = emailRepository.findOne(savedEmail.getId());

		assertNotNull(findedEmail);
		assertEquals(savedEmail.getId(), findedEmail.getId());
		assertEquals(email.getValue(), findedEmail.getValue());
	}

}
