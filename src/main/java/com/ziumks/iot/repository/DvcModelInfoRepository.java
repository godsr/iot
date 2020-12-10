package com.ziumks.iot.repository;

import com.ziumks.iot.domain.DvcInfo;
import com.ziumks.iot.domain.DvcModelInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DvcModelInfoRepository extends JpaRepository<DvcModelInfo, Long>{

	List<DvcModelInfo> findByDvcModelId(String id);
}
