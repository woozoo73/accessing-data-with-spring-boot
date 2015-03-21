package com.bluedigm.adwsb.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bluedigm.adwsb.AbstractSpringTest;
import com.bluedigm.adwsb.domain.Project;

public class ProjectRepositoryTest extends AbstractSpringTest {

	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void test() {
		Project project= new Project();
		project.setName("test-project");

		Project savedProject = projectRepository.save(project);

		logger.debug("savedProject={}", savedProject);
		assertNotNull(savedProject);

		Project findedProject = projectRepository.findOne(savedProject.getId());

		assertNotNull(findedProject);
		assertEquals(savedProject.getId(), findedProject.getId());
		assertEquals(project.getName(), findedProject.getName());
	}

}
