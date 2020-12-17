package com.ziumks.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ziumks.iot.domain.TagInfo;

public interface TagInfoRepository extends JpaRepository<TagInfo, String>{

	@Query(nativeQuery = true, 
			value = "update iot_web.tag_info set clientCd=:#{#paramTagInfo.clientCd}, "
					+ "siteCd=:#{#paramTagInfo.siteCd}, "
					+ "tagTypeNm=:#{#paramTagInfo.tagTypeNm}, "
					+ "tagUnitNm=:#{#paramTagInfo.tagUnitNm}, "
					+ "tagCd=:#{#paramTagInfo.tagCd}, "
					+ "tagNm=:#{#paramTagInfo.tagNm}, "
					+ "creDtm=:#{#paramTagInfo.creDtm} "
					+ "where tag_info.tag_id=:#{#paramTagInfo.tagId}")
	int tagInfoUpdate (@Param("paramTagInfo") TagInfo tagInfo);
}
