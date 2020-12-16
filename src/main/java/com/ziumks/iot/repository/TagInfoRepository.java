package com.ziumks.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ziumks.iot.domain.TagInfo;

public interface TagInfoRepository extends JpaRepository<TagInfo, String>{

	@Query(nativeQuery = true, 
			value = "update iot_web.tag_info set clientCd=:tagInfo.clientCd,"
					+ "siteCd=:tagInfo.siteCd,"
					+ "tagTypeNm=:tagInfo.tagTypeNm"
					+ "tagUnitNm=:tagInfo.tagUnitNm"
					+ "tagCd=:tagInfo.tagCd"
					+ "tagNm=:tagInfo.tagNm"
					+ "creDtm=:tagInfo.crdDtm")
	int tagInfoUpdate (TagInfo tagInfo);
}
