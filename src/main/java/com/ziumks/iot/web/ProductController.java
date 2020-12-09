package com.ziumks.iot.web;

import com.ziumks.iot.domain.Account;
import com.ziumks.iot.repository.AccountRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Logger logger = LogManager.getLogger(MainController.class);

    @Autowired
    AccountRepository repository;


    @RequestMapping("/list")
    public ResponseEntity read(Model model) {
        Account account = new Account();
        account.setId(8l);
        account.setUsername("poland");
        account.setEmail("poland@pol.com");
        return new ResponseEntity(account, HttpStatus.OK);
    }

    @GetMapping("/paging")
    public ResponseEntity<Page> findBooksByPageRequest(final Pageable pageable) {

        Page<Account> page =  repository.findAll(pageable);
        long total = page.getTotalElements();
        List<Account> list = page.getContent();
        ResponseEntity<Page> resp = new ResponseEntity<Page>(page, HttpStatus.OK);

        return resp;
    }

    @GetMapping("/opt")
    @ResponseBody
    public Account opt(final Pageable pageable) {
        long id = 8l;
        Optional<Account> user = repository.findById(id);
      //  ResponseEntity<Optional<Account>> res = new ResponseEntity<Optional<Account>> (user, HttpStatus.OK);
        Account realuser = user.get();
        return realuser;
    }
}
