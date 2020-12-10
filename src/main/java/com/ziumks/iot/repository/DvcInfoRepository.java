package com.ziumks.iot.repository;

import com.ziumks.iot.domain.Author;
import com.ziumks.iot.domain.DvcInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DvcInfoRepository extends JpaRepository<DvcInfo, Long>{

	List<DvcInfo> findByDvcId(String id);
}
