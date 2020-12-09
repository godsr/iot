package com.ziumks.iot.web;

import com.ziumks.iot.domain.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Logger logger = LogManager.getLogger(MainController.class);

    @RequestMapping("/list")
    public ResponseEntity read(Model model) {
        Account account = new Account();
        account.setId(8l);
        account.setUsername("poland");
        account.setEmail("poland@pol.com");
        return new ResponseEntity(account, HttpStatus.OK);
    }
}
