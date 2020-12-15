package com.ziumks.iot.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ziumks.iot.domain.CompanyInfo;

public interface CompanyRepository extends JpaRepository<CompanyInfo, String> {
	@Query(nativeQuery = true, value = "delete from Companyinfo where co_id = :coId")
	void deleteByCoId(String coId);
//	@Query(nativeQuery = true, value = "select * from Companyinfo where id < :id")
//	List<CompanyInfo> findByIdRange(String coId);
}
