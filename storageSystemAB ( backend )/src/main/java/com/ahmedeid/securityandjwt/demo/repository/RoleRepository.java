package com.ahmedeid.securityandjwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmedeid.securityandjwt.demo.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
