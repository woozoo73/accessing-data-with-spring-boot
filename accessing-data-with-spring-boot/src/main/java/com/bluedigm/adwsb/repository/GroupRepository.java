package com.bluedigm.adwsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.bluedigm.adwsb.domain.Group;

public interface GroupRepository extends JpaRepository<Group, Integer>, QueryDslPredicateExecutor<Group> {

}
