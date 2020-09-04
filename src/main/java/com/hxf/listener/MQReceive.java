package com.hxf.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author: hxf
 * @date: 2020/1/15 20:07
 * @description:
 */
@Service
public class MQReceive {

    private static final String EXCHANGE_ANSWER_CACHE = "hxf_test";

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(durable = "true",
            autoDelete = "true", exclusive = "false"), exchange = @Exchange(value = EXCHANGE_ANSWER_CACHE, type = ExchangeTypes.FANOUT))})
    public void cacheAnswer(Message message, Channel channel) {
        try {
            String msg = new String(message.getBody(), "utf-8");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            try {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            } catch (IOException e1) {
            }
        }
    }

}
