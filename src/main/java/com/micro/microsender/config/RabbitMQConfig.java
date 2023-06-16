package com.micro.microsender.config;

import com.micro.microsender.model.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private static final Logger logger = LogManager.getLogger(RabbitMQConfig.class);

//    @Value("${spring.rabbitmq.queue}")
//    private String queue;
//    @Value("${spring.rabbitmq.exchange}")
//    private String exchange;
//    @Value("${spring.rabbitmq.routingkey}")
//    private String routingKey;
//    @Value("${spring.rabbitmq.username}")
//    private String username;
//    @Value("${spring.rabbitmq.password}")
//    private String password;
//    @Value("${spring.rabbitmq.host}")
//    private String host;


    @Bean
    public Queue queue() {
        return new Queue(Constants.QUEUE);
    }
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(Constants.EXCHANGE);
    }
    @Bean
    public Binding binding(Queue queue , TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(Constants.ROUTING_KEY);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}
