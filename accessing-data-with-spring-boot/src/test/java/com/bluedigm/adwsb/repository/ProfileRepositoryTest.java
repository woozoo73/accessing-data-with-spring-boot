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
import com.bluedigm.adwsb.domain.Profile;
import com.bluedigm.adwsb.domain.Project;

public class ProfileRepositoryTest extends AbstractSpringTest {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	ProfileRepository profileRepository;

	List<Project> savedProjects;

	@Before
	public void setUp() throws Exception {
		savedProjects = new ArrayList<Project>();
		for (int i = 0; i < 3; i++) {
			Project project = new Project();
			project.setName("test-project-" + i);

			savedProjects.add(projectRepository.save(project));
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Profile profile = new Profile();
		profile.setMemberId(UUID.randomUUID().toString());
		profile.setProjects(savedProjects);

		Profile savedProfile = profileRepository.save(profile);

		logger.debug("savedProfile={}", savedProfile);
		assertNotNull(savedProfile);

		Profile findedProfile = profileRepository.findOne(savedProfile.getId());

		assertNotNull(findedProfile);
		assertEquals(savedProjects.size(), savedProfile.getProjects().size());
		assertEquals(savedProjects.get(0).getName(), savedProfile.getProjects().get(0).getName());

		Profile profileOfMember = profileRepository.findByMemberId(profile.getMemberId());
		
		logger.debug("profileOfMember={}", profileOfMember);
		assertEquals(profile.getMemberId(), profileOfMember.getMemberId());
	}

}
