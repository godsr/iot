package com.ziumks.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ziumks.iot.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	@Query(nativeQuery = true, value = "select * from account where username = :Username")
	Account findByUsername(String Username);
}
