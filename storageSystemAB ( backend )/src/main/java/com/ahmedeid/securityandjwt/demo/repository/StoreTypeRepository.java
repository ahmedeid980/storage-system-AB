package com.ahmedeid.securityandjwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmedeid.securityandjwt.demo.entities.StoreType;

public interface StoreTypeRepository extends JpaRepository<StoreType, Integer> {

}
