package com.humc.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "--------paymentFallbackService fall back-paymentInfo_Ok";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "--------paymentFallbackService fall back-paymentInfo_timeout";
    }
}
