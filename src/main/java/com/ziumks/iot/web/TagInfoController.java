package com.ziumks.iot.web;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziumks.iot.domain.Author;
import com.ziumks.iot.domain.TagInfo;
import com.ziumks.iot.repository.TagInfoRepository;

@Controller
@RequestMapping("/taginfo")
public class TagInfoController {
	
    private static final Logger logger = LogManager.getLogger(TagInfoController.class);
    
    @Autowired
    TagInfoRepository repository;
    
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
    	
    	return "create success";
    }
    
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String updateTagInfo(@RequestBody TagInfo tagInfo) {
    	System.out.println(tagInfo);
    	repository.tagInfoUpdate(tagInfo);
    	return "save success";
    }
    
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteTagInfo(@RequestBody TagInfo tagInfo) {
    	System.out.println(tagInfo);
    	repository.delete(tagInfo);
    	return "delete success";
    }
    
    
}
