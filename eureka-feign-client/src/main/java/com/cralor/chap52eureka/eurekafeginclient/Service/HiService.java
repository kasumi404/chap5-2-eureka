package com.cralor.chap52eureka.eurekafeginclient.Service;

import com.cralor.chap52eureka.eurekafeginclient.Service.ServiceImpt.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiService {
    @Autowired
    EurekaClientFeign eurekaClientFeign;

    public  String sayHi(String name){
        return eurekaClientFeign.sayHiFromClientEureka(name);
    }
}