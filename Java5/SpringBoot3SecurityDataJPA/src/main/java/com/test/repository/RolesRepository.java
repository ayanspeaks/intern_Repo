package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer>
{

}
