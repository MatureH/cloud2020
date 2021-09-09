package com.humc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: NacosProviderMain9001
 * date: 2021/9/9 9:58
 *
 * @author: humc
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain9001.class, args);
    }
}
