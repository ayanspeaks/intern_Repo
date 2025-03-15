package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.test.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/*
	@Query("select u from user u where u.firstName = ?1")
	public User getByFirstName(String firstName) {
		return getByFirstName(firstName);
	}
	*/
}