package com.humc.springcloud.service.impl;

import com.humc.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * ClassName: MessageProviderImpl
 * date: 2021/9/7 17:03
 *
 * @author: humc
 */
@EnableBinding(Source.class) // 定义消息管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;  // 笑死发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*********serial:" + serial);
        return null;
    }
}
