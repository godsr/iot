package com.ziumks.iot.web.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class Resp extends ResponseEntity {
    public Resp(HttpStatus status) {
        super(status, HttpStatus.OK);
    }

    public Resp(Object body, HttpStatus status) {
        super(body, status);
    }

}
