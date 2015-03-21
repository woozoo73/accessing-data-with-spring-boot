package com.bluedigm.adwsb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bluedigm.adwsb.domain.Project;

public interface ProjectRepository extends MongoRepository<Project, String> {

}
