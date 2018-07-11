package com.example.demo.rabbitMQ.controller;

import com.example.demo.rabbitMQ.RabbitConfig;
import com.example.demo.rabbitMQ.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author gzhou2
 * @date 2018/7/9 15:02
 */
@RestController
@RequestMapping(value = "/books")
public class BookController {
    private static Logger logger = LoggerFactory.getLogger(BookController.class);


    private RabbitTemplate rabbitTemplate;

    @Autowired
    public BookController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping
    public void defaultMessage() {
        Book book = new Book();
        book.setId(111);
        book.setName("asdfasdf asdf");

        this.rabbitTemplate.convertAndSend(RabbitConfig.REGISTER_DELAY_EXCHANGE, RabbitConfig.DELAY_ROUTING_KEY, book,
                message -> {
//            第一句是可要可不要,根据自己需要自行处理
                    message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, Book.class.getName());
//            如果配置了 params.put("x-message-ttl", 5 * 1000); 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
                    message.getMessageProperties().setExpiration(5 * 1000 + "");
                    return message;
                });
        logger.info("[发送时间] - [{}]", LocalDateTime.now());
    }

}
