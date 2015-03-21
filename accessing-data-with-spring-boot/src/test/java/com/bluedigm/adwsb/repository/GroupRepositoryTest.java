package com.bluedigm.adwsb.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bluedigm.adwsb.AbstractSpringTest;
import com.bluedigm.adwsb.domain.Group;

public class GroupRepositoryTest extends AbstractSpringTest {

	@Autowired
	GroupRepository groupRepository;

	@Test
	public void test() {
		Group group = new Group();
		group.setName("test-group");

		Group savedGroup = groupRepository.save(group);

		logger.debug("savedGroup={}", savedGroup);
		assertNotNull(savedGroup);

		Group findedGroup = groupRepository.findOne(savedGroup.getId());

		assertNotNull(findedGroup);
		assertEquals(savedGroup.getId(), findedGroup.getId());
		assertEquals(group.getName(), findedGroup.getName());
	}

}
