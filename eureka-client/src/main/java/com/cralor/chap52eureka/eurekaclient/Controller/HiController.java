package com.cralor.chap52eureka.eurekaclient.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    public String Home(@RequestParam String name){
        return "hi "+name+",i am from port:"+port;
    }
}