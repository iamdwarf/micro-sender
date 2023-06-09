//package com.micro.microsender.component;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
//@Component
//public class Sender {
//    private static final Logger logger = LogManager.getLogger(Sender.class);
//    private final static String QUEUE_NAME = "hello";
//    public void send() throws IOException, TimeoutException {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("localhost");
//        try(Connection connection = factory.newConnection();
//            Channel channel = connection.createChannel()){
//            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//            String message = "Hello World";
//            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
//            System.out.println(" [x] Sent '" + message + "'");
//            logger.info(" [x] Sent '" + message + "'");
//        }
//    }
//
///*
//    private RabbitTemplate rabbitTemplate;
//    @Autowired
//    public Sender(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//    @Value("${spring.rabbitmq.exchange}")
//    private String exchange;
//    @Value("${spring.rabbitmq.routingkey}")
//    private String routingkey;
//    public void send(String message){
//        rabbitTemplate.convertAndSend(exchange,routingkey, "user's message");
//        logger.info(exchange, routingkey, "user's message");
//    }
// */
//
//}