package com.humc.springcloud.controller;

import com.humc.springcloud.entities.CommonResult;
import com.humc.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderConsulController {

//    public static final String PAYMENT_URL = "http://localhost:7001";
    public static final String PAYMENT_URL = "http://consul-provider-payment"; // 根据微服务名称获取服务

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/consul")
    public CommonResult create() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", CommonResult.class);
    }

}
