package com.bluedigm.adwsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.bluedigm.adwsb.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>, QueryDslPredicateExecutor<Member> {

}
