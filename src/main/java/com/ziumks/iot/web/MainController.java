package com.ziumks.iot.web;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziumks.iot.domain.Author;
import com.ziumks.iot.domain.Post;
import com.ziumks.iot.repository.PostRepository;


@Controller
public class MainController {
	
	private static final Logger logger = LogManager.getLogger(MainController.class);
	@Autowired
//	AccountRepository repository;
	PostRepository postrepository;
	
//	@RequestMapping("/")
//	public String list(Model model) {
//		logger.info("list start: ");
//		List<Account> accountList = repository.findAll(Sort.by(Sort.Direction.ASC,"id"));
//		model.addAttribute("title", "hello world");
//		model.addAttribute("accountList", accountList);
//		return "index";
//	}
//	@RequestMapping("/search")
//	public String search(@RequestParam(value="keyword")String keyword, Model model) {
//		List<Account> accountList = repository.findOne(id);
//	}
	@RequestMapping("/index/{id}")
	@ResponseBody
	public Post read(@PathVariable("id")Long id, Model model) {
		Optional<Post> user = postrepository.findById(id);
		Post post = null;
		if(user.isPresent()) {
			post = user.get();
		} else {
			logger.info("account is null");
		}
		logger.info(post);
		return post;
	}
	@RequestMapping("/")
	public String post(Model model, Pageable pageable) {
		logger.info("list start: ");
		Page<Post> postList = postrepository.findAll(pageable);
		int startPage = Math.max(0, postList.getPageable().getPageNumber() -5);
		int endPage = Math.min(postList.getTotalPages(), postList.getPageable().getPageNumber() +5);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("postList", postList);
		model.addAttribute("pagenation", 5);
		
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<String> update(@RequestBody Post post) {
		System.out.println(post);
		post = postrepository.save(post);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
//	@RequestMapping("/index/{id}")
//	@RequestBody
//	public int modify(Post post) {
//		int result = postrepository.save(post.getId());
//		return result;
//	}
	
//	@RequestMapping("/")
//	public String list(Model model) {
//		logger.info("list start: ");
//		List<Post> postList = postrepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
//		model.addAttribute("title", "hello world");
//		model.addAttribute("postList", postList);
//		return "index";
//	}	
	
//	@RequestMapping("/")
//	public ResponseEntity post(final Pageable pageable) {
//		Page<Post> posts = postrepository.findAll(pageable);
//		return new ResponseEntity<>(posts,HttpStatus.OK);
//	}
	
//	@RequestMapping("/paging")
//	@ResponseBody
//	public MyPageData findBooksByPageRequest(final Pageable pageable) {
//	    Page<Post> page =  postrepository.findAll(pageable);
//	    long total = page.getTotalElements();
//	    List<Post> list = page.getContent();
//	    ResponseEntity<Page> resp = new ResponseEntity<Page>(page, HttpStatus.OK);
//	    MyPageData myPage = new MyPageData();
//	    myPage.setData( list);
//	    myPage.setRecordsTotal( page.getTotalElements() );
//	    return myPage;
//	}
}
