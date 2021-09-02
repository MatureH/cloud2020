package com.humc.springcloud.controller;

import com.humc.springcloud.entities.CommonResult;
import com.humc.springcloud.entities.Payment;
import com.humc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result =  paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功 + serverPort" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment == null) {
            return new CommonResult(444, "查询没有该条记录", null);
        } else {
            return new CommonResult(200, "查询到一条数据 + serverPort" + serverPort, payment);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/timeout")
    public String getTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
