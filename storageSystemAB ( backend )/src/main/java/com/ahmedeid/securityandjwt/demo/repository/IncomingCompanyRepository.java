package com.ahmedeid.securityandjwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmedeid.securityandjwt.demo.entities.IncomingCompany;

public interface IncomingCompanyRepository extends JpaRepository<IncomingCompany, Integer> {

}
