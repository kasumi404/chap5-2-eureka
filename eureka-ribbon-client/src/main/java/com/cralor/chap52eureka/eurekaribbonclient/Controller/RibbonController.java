package com.cralor.chap52eureka.eurekaribbonclient.Controller;

import com.cralor.chap52eureka.eurekaribbonclient.Service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
    @Autowired
    private RibbonService ribbonService;

    @GetMapping("/hi")
    public String hi(@RequestParam(required = false,defaultValue = "cralor") String name){
        return ribbonService.hi(name);
    }

    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/testRibbon")
    public String testRibbon(){
        ServiceInstance instance=loadBalancer.choose("eureka-client");
        return instance.getHost()+":"+instance.getPort();
    }
}