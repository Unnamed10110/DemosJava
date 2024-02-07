package com.example.demo00.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RestDemo {

    @GetMapping("/")
    public String HelloWorld(){
        return "Hello World 00!";
    }

    @GetMapping("/test")
    public String Test(){
        return "Test controller!";
    }

    //using custom properties
    @Value("${coach.name}")
    private String CoachName;
    @Value("${team.name}")
    private String TeamName;
    @GetMapping("/teaminfo")
    public Object teamInfo(){
        HashMap<String,Object> map = new HashMap<>(2);
        map.put("coach", CoachName);
        map.put("team", TeamName);


        return map;
    }

}
