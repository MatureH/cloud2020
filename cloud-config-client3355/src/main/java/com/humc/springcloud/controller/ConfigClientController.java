package com.humc.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ConfigClientController
 * date: 2021/9/6 15:08
 *
 * @author: humc
 */
@RestController
@Slf4j
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/serverPort")
    public String getServerPort() {
        return serverPort;
    }

}
