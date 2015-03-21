package com.bluedigm.adwsb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bluedigm.adwsb.domain.Profile;

public interface ProfileRepository extends MongoRepository<Profile, String> {

	Profile findByMemberId(String memberId);

}
