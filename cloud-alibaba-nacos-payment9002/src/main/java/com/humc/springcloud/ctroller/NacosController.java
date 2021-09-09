package com.humc.springcloud.ctroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: NacosController
 * date: 2021/9/9 10:51
 *
 * @author: humc
 */
@RestController
public class NacosController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/nacos/{id}")
    public String getNacos(@PathVariable("id") String id) {
        return "hello nacos server: " + id + "serverPort: " + serverPort;
    }
}
