package com.ziumks.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ziumks.iot.domain.TagInfo;

public interface TagInfoRepository extends JpaRepository<TagInfo, String>{

}
