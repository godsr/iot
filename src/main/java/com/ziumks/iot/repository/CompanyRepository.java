package com.ziumks.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ziumks.iot.domain.CompanyInfo;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyInfo, String> {
	
}
