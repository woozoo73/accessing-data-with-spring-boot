package com.bluedigm.adwsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.bluedigm.adwsb.domain.Email;

public interface EmailRepository extends JpaRepository<Email, Integer>, QueryDslPredicateExecutor<Email> {

}
