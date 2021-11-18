package com.eplat.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WebController {

    @RequestMapping("/welcome")
    public String sayHello(){
        return "Howdy!";
    }

    @RequestMapping("/bye")
    public String sayBye() {
        return "Au roveour";
    }
}
