package com.ziumks.iot.web;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziumks.iot.domain.Account;
import com.ziumks.iot.repository.AccountRepository;


@Controller
public class UserController {
	
	private static final Logger logger = LogManager.getLogger(UserController.class);
	@Autowired
	AccountRepository repository;
	
	@RequestMapping("/")
	public String list(Model model) {
		logger.info("list start: ");
		List<Account> accountList = repository.findAll(Sort.by(Sort.Direction.ASC,"id"));
		model.addAttribute("title", "hello world");
		model.addAttribute("accountList", accountList);
		return "index";
	}
//	@RequestMapping("/search")
//	public String search(@RequestParam(value="keyword")String keyword, Model model) {
//		List<Account> accountList = repository.findOne(id);
//	}
	@RequestMapping("/index/{id}")
	@ResponseBody
	public Account read(@PathVariable("id")Long id, Model model) {
		Optional<Account> user = repository.findById(id);
		Account account = null;
		if(user.isPresent()) {
			account = user.get();
		} else {
			logger.info("account is null");
		}
		logger.info(account);
		return account;
	}
}
