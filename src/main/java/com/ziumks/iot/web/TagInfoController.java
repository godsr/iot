package com.ziumks.iot.web;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.ziumks.iot.config.CommonCode;
import com.ziumks.iot.domain.TagInfo;
import com.ziumks.iot.repository.TagInfoRepository;
import com.ziumks.iot.response.TagInfoResponse;
import com.ziumks.iot.service.TagInfoService;

@Controller
@RequestMapping("/taginfo")
public class TagInfoController {
	
    private static final Logger logger = LogManager.getLogger(TagInfoController.class);
    
    @Autowired
    TagInfoRepository repository;
    
    @Autowired
    TagInfoService service;
    
    @RequestMapping("/")
    public String list(HttpServletRequest request, Model model, 
    		@PageableDefault(sort = { "creDtm" }, direction = Direction.DESC, size = 5) Pageable pageable) {
    	
    	logger.info("tagInfoList start : ");
    	Page<TagInfo> tagInfos = repository.findAll(pageable);

    	String pageTag = PagerTag.by(tagInfos, request.getRequestURI());

    	model.addAttribute("pagerTag", pageTag);
    	model.addAttribute("list", tagInfos.getContent());
    	System.out.println(pageTag);
    	return "tagInfo";
    }
    
    @RequestMapping("/{tagId}")
    @ResponseBody
    public TagInfo oneInfo(@PathVariable("tagId")String tagId, Model model) {
    	Optional<TagInfo> tagInfoOptional = repository.findById(tagId);
    	TagInfo tagInfo = null;
    	if (tagInfoOptional.isPresent()) {
    		tagInfo = tagInfoOptional.get();
		} else {
			logger.info("db에 해당 id가 없습니다.");
		}
    	logger.info(tagInfo);
    	return tagInfo;
    }
    
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createTagInfo(@RequestBody TagInfo tagInfo) {
    	System.out.println(tagInfo);
    	tagInfo.setTagId(UUID.randomUUID().toString().replaceAll("-", ""));
    	repository.save(tagInfo);
    	return "create success";
    }
    
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.PUT)
    public String updateTagInfo(@RequestBody TagInfo tagInfo) {
    	System.out.println(tagInfo);
//    	repository.tagInfoUpdate(tagInfo);
    	repository.save(tagInfo);
    	return "save success";
    }
    
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteTagInfo(@RequestBody TagInfo tagInfo) {
    	System.out.println(tagInfo);
    	repository.delete(tagInfo);
    	return "delete success";
    }
    
    @RequestMapping(value="/search", method = {RequestMethod.POST} )
    public String getList(
    		HttpServletRequest request,
    		HttpServletResponse response,
			@ModelAttribute TagInfo tagInfo,
    		Model model){

    	Map<String, Object> paramMap = Maps.newConcurrentMap();
    	paramMap.put("page", "1");
    	paramMap.put("rows", "10");
//    	paramMap.put("sortIndex", sortIndex);
//    	paramMap.put("sortColumn", tagInfo);
//    	

//		if(user != null){
//			if(!user.getUserGrd().equals("1")){
//				paramMap.put("clientCd", user.getClientCd());
//			}
//			else{
//				paramMap.put("clientCd", clientCd);
//			}
//
//			if(Strings.isNullOrEmpty(siteCd)) paramMap.put("siteCd", "all");
//			else paramMap.put("siteCd", siteCd);
//		}
    	paramMap.put("siteCd", tagInfo.getSiteCd());
    	paramMap.put("tagNm", tagInfo.getTagNm());
    	paramMap.put("tagType", tagInfo.getTagType());
//		paramMap.put("user", user);

    	TagInfoResponse responseData = service.getList(paramMap);

    	
    	model.addAttribute("list", responseData.getData());
    	
    	
		
        return "tagInfo";
    }

}
