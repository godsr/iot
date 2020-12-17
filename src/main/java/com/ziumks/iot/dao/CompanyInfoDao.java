package com.ziumks.iot.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository(value = "CompanyInfoDao")
public class CompanyInfoDao {
	
	@PersistenceContext
	EntityManager em;
	
}
