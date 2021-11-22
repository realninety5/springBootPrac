package com.eplat.web;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WebController {

    @RequestMapping("/welcome")
    public ResponseEntity<String> sayHello(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo");

        return new ResponseEntity<>(
                "Custom header set", headers, HttpStatus.OK);
//        return "Howdy!";
    }

    @RequestMapping("/bye")
    public String sayBye() {
        return "So Long";
    }
}
