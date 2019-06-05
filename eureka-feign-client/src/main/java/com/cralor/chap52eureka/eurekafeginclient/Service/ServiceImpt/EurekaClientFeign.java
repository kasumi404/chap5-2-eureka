package com.cralor.chap52eureka.eurekafeginclient.Service.ServiceImpt;

import com.cralor.chap52eureka.eurekafeginclient.Config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "eureka-client",configuration = FeignConfig.class)
public interface EurekaClientFeign {
    @GetMapping(value = "/hi")
    String sayHiFromClientEureka(@RequestParam(value = "name")String name);
}