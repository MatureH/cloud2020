package com.humc.springcloud.service;

import com.humc.springcloud.entities.CommonResult;
import com.humc.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/timeout")
    public String getTimeout();
}
