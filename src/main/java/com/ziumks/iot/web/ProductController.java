package com.ziumks.iot.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ziumks.iot.domain.Account;
import com.ziumks.iot.domain.DvcInfo;
import com.ziumks.iot.repository.DvcInfoRepository;

@Controller
@RequestMapping("/prod")
public class ProductController {

    private static final Logger logger = LogManager.getLogger(ProductController.class);

    @Autowired
    DvcInfoRepository repository;
    


    @RequestMapping("")
    public String list(Model model) {
        logger.info("list start: ");
        model.addAttribute("pageTitle", "Iot Admin");
        model.addAttribute("pageSubTitle", "tipa site 관리");
        return "prod";
    }

    @RequestMapping("/plist")
    public String plist(HttpServletRequest request, Model model, Pageable pageable) {
        logger.info("plist start: ");
        Page<DvcInfo> dvcInfos = repository.findAll(pageable);
        model.addAttribute("pageTitle", "Iot Admin");
        model.addAttribute("pageSubTitle", "tipa site 관리");

        
        String pageTag = PagerTag.by(dvcInfos, request.getRequestURI());
        
        model.addAttribute("pagerTag", pageTag);
        model.addAttribute("list", dvcInfos.getContent());
        System.out.println(pageTag);
//        return new ResponseEntity<>(dvcInfos, HttpStatus.OK);
        return "pgprod";
    }
    
    
    
    @RequestMapping("/list")
    public  HttpEntity<Account>  read(Model model) {
        Account account = new Account();
        account.setId(8l);
        account.setUsername("poland");
        account.setEmail("poland@pol.com");
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

//    @GetMapping("/paging")
//    @ResponseBody
//    public MyPageData findBooksByPageRequest(final Pageable pageable) {
//
//        Page<Account> page =  repository.findAll(pageable);
//        long total = page.getTotalElements();
//        List<Account> list = page.getContent();
//
//        //ResponseEntity<Page> resp = new ResponseEntity<Page>(page, HttpStatus.OK);
//        MyPageData myPage = new MyPageData();
//        myPage.setData( list);
//        myPage.setRecordsTotal( page.getTotalElements() );
//        return myPage;
//    }

//    @GetMapping("/opt")
//    @ResponseBody
//    public Account opt(final Pageable pageable) {
//        long id = 8l;
//        Optional<Account> user = repository.findById(id);
//      //  ResponseEntity<Optional<Account>> res = new ResponseEntity<Optional<Account>> (user, HttpStatus.OK);
//        Account realuser = user.get();
//        return realuser;
//    }
}
