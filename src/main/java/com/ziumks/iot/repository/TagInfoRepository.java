package com.ziumks.iot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ziumks.iot.domain.ClientCd;
import com.ziumks.iot.domain.TagInfo;

public interface TagInfoRepository extends JpaRepository<TagInfo, String>{

	@Transactional
	@Modifying
	@Query(nativeQuery = true, 
			value = "update iot_web.tag_info set client_cd=:#{#paramTagInfo.clientCd}, "
					+ "site_cd=:#{#paramTagInfo.siteCd}, "
					+ "tag_unit_nm=:#{#paramTagInfo.tagUnitNm}, "
					+ "tag_cd=:#{#paramTagInfo.tagCd}, "
					+ "tag_nm=:#{#paramTagInfo.tagNm}, "
					+ "cre_dtm=:#{#paramTagInfo.creDtm} "
					+ "where tag_id=:#{#paramTagInfo.tagId}")
	int tagInfoUpdate (@Param("paramTagInfo") TagInfo tagInfo);
	
	
	
}
