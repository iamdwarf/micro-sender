//package com.micro.microsender.service;
//
//import com.micro.microsender.model.User;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SenderService {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    public SenderService(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    @Value("${spring.rabbitmq.exchange}")
//    private String exchange;
//
//    @Value("${spring.rabbitmq.routingkey}")
//    private String routingkey;
//
//    public void sendMessage(User user) {
//        System.out.println(exchange + " " + routingkey + " " + user.getMessage());
//        rabbitTemplate.convertAndSend(exchange,routingkey, user.getMessage());
//    }
//
//}
