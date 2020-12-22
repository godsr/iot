package com.ziumks.iot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ziumks.iot.domain.ClientCd;

public interface ClientCdRepository extends JpaRepository<ClientCd, String>{

	@Query(nativeQuery = true,
			value = "select client_cd, client_nm from oms.oms_client_info")
	List<ClientCd> getClientCdList();
}
