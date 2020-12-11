package com.ziumks.iot.web;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziumks.iot.domain.Author;
import com.ziumks.iot.repository.AuthorRepository;

@Controller
@RequestMapping("user")
public class AuthorController {

	 private static final Logger logger = LogManager.getLogger(AuthorController.class);

	    @Autowired
	    AuthorRepository repository;

	    @RequestMapping("/list")
	    public String author(Model model) {
	    	List<Author> authorList = repository.findByIdRange(20L);
	        model.addAttribute("list", authorList);
	        return "user";
	    }
	    
	    @RequestMapping("/{id}")
	    @ResponseBody
	    public Author oneauthor(@PathVariable("id")Long id, Model model) {
	    	Optional<Author> author = repository.findById(id);
	    	Author list = null;
	    	if (author.isPresent()) {
				list = author.get();
			} else {
				logger.info("list is null.");
			}
	    	logger.info(list);
	        return list;
	    }
	    
	    @ResponseBody
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String updateAuthor(@RequestBody Author author) {
			System.out.println(author);
			repository.save(author);
			return "success";
		}

}
