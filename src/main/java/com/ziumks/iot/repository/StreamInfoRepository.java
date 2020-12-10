package com.ziumks.iot.repository;

import com.ziumks.iot.domain.DvcInfo;
import com.ziumks.iot.domain.StreamInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StreamInfoRepository extends JpaRepository<StreamInfo, Long>{

	List<StreamInfo> findByStreamPkId(String id);
}
