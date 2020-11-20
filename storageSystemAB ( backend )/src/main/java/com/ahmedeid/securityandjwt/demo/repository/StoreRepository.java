package com.ahmedeid.securityandjwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmedeid.securityandjwt.demo.entities.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {

}
