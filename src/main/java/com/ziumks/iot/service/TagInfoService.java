package com.ziumks.iot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.google.common.collect.Lists;
import com.ziumks.iot.dao.TagInfoDao;
import com.ziumks.iot.domain.TagInfo;
import com.ziumks.iot.response.TagInfoPageInfo;
import com.ziumks.iot.response.TagInfoResponse;

@Service
public class TagInfoService {

	@Autowired
	TagInfoDao dao;
	
    public TagInfoResponse getList(Map<String, Object> paramMap){
    	
    	String page = paramMap.get("page") == null ? "" : paramMap.get("page").toString(); 
    	String rows = paramMap.get("rows") == null ? "" : paramMap.get("rows").toString(); 
    	int totalRows = dao.getTotalCount(paramMap);
    	
    	/****page Info 설정*****/
		TagInfoPageInfo pageInfo = new TagInfoPageInfo();
		pageInfo.setPage(page);
		pageInfo.setRows(rows);
		pageInfo.setTotalRows(String.valueOf(totalRows));
		pageInfo.execute();

		List<TagInfo> TagInfos = Lists.newArrayList();
		if (totalRows > 0) {
			TagInfos = dao.getList(paramMap);
		}
		
		TagInfoResponse response = new TagInfoResponse();
		response.setPageInfo(pageInfo);
		response.setData(TagInfos);
    	
//    	List<DvcModelInfo> dvcModelInfos = dao.getList(paramMap);
    	return response;
    }
}
