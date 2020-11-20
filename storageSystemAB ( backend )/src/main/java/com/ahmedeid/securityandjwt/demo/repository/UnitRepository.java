package com.ahmedeid.securityandjwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmedeid.securityandjwt.demo.entities.Unit;

public interface UnitRepository extends JpaRepository<Unit, Integer> {

}
