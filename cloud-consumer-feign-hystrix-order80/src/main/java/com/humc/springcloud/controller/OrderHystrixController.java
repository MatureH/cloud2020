package com.humc.springcloud.controller;

import com.humc.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallBackMethod", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
    @HystrixCommand
    public String pymentInfo_Timeout(@PathVariable("id") Integer id) {
        int age = 10/0;
        return paymentHystrixService.paymentInfo_Timeout(id);
    }


    // 下面是全局fallback
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后再试, /(T.T)/~~";
    }

    public String paymentTimeOutFallBackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80，对方支付系统繁忙，请10秒钟后重试或者自己运行出错请检查自己, **";
    }



}
