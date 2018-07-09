package com.example.demo.rabbitMQ.consumer;

import com.example.demo.rabbitMQ.RabbitConfig;
import com.example.demo.rabbitMQ.model.Book;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author gzhou2
 * @date 2018/7/9 15:17
 */

@Component
public class BookHandler {

    private static Logger logger = LoggerFactory.getLogger(BookHandler.class);

    @RabbitListener(queues = {RabbitConfig.REGISTER_QUEUE_NAME})
    public void listenerDelayQueue(Book book, Message message, Channel channel) {

        logger.info("[listenerDelayQueue 监听的消息] - [消费时间] - [{}] - [{}]", LocalDateTime.now(), book.toString());
        try{
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }catch (IOException e){
            e.printStackTrace();
//            如果报错了,那么我们可以进行容错处理,比如转移当前消息进入其它队列
        }

    }

}
