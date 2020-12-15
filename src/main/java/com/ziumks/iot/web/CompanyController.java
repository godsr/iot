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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziumks.iot.domain.CompanyInfo;
import com.ziumks.iot.repository.CompanyRepository;

@Controller
@RequestMapping("/comp")
public class CompanyController {
    private static final Logger logger = LogManager.getLogger(CompanyController.class);
    @Autowired
    CompanyRepository repository;
    
    
    @RequestMapping("/")
    public String plist(HttpServletRequest request, Model model, @PageableDefault(sort = { "coId" }, direction = Direction.ASC, size = 5) Pageable pageable) {
        logger.info("comp info: ");
        Page<CompanyInfo> compinfos = repository.findAll(pageable);
        
        String pageTag = PagerTag.by(compinfos, request.getRequestURI());
        
        model.addAttribute("pagerTag", pageTag);
        model.addAttribute("compList", compinfos.getContent());
        return "company";
	}

//    	@RequestMapping("/")
//	public String list(Model model) {
//		logger.info("list start: ");
//		List<CompanyInfo> compList = repository.findAll();
//		model.addAttribute("title", "hello world");
//		model.addAttribute("compList", compList);
//		return "company";
//	}
    
	@RequestMapping("/index/{coId}")
	@ResponseBody
	public CompanyInfo read(@PathVariable("coId")String coId, Model model) {
		Optional<CompanyInfo> company = repository.findById(coId);
		CompanyInfo comp = null;
		if(company.isPresent()) {
			comp = company.get();
		} else {
			logger.info("account is null");
		}
		logger.info(comp);
		return comp;
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<String> update(@RequestBody CompanyInfo companyInfo) {
		companyInfo = repository.save(companyInfo);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestBody String coId) {
		
		repository.deleteByCoId(coId);
	}
}
