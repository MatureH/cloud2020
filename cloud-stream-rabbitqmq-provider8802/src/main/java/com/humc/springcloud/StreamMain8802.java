package com.humc.springcloud;

import lombok.experimental.ExtensionMethod;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ClassName: StreamMain8802
 * date: 2021/9/7 17:32
 *
 * @author: humc
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMain8802.class, args);
    }
}
