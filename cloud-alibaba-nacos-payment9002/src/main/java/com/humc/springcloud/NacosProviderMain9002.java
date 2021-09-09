package com.humc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: NacosProviderMain9002
 * date: 2021/9/9 10:50
 *
 * @author: humc
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9002 {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain9002.class, args);
    }
}
