package com.unnamed.demoREST.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoRestController {
    public DemoRestController() {
    }


    @GetMapping("/hello")
    public String sayHello(){
        return "Hellow world!!";
    }

}
