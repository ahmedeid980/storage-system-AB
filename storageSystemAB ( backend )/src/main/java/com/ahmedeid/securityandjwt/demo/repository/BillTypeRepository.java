package com.ahmedeid.securityandjwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmedeid.securityandjwt.demo.entities.BillType;

public interface BillTypeRepository extends JpaRepository<BillType, Integer> {

}
