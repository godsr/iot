package com.ziumks.iot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ziumks.iot.domain.TagUnit;

public interface TagUnitRepository extends JpaRepository<TagUnit, String>{

	@Query(nativeQuery = true,
			value = "select cd_id, cd_desc, cd_nm, grup_cd "
					+ "from iot_web.comm_cd_info "
					+ "where grup_cd = 'IOT004'")
	List<TagUnit> getTagUnit();
}
