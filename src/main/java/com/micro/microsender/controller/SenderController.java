package com.micro.microsender.controller;

import com.micro.microsender.MicroSenderApplication;
import com.micro.microsender.model.Constants;
import com.micro.microsender.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


@Controller
public class SenderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    Map<User, List<String>> userMessages = new ConcurrentHashMap<>();

    private static final Logger logger = LogManager.getLogger(MicroSenderApplication.class);

    @RequestMapping(value="/user", method= RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("user", new User());
        logger.info("new user data was sent");
        return "user-form";
    }

    @RequestMapping(value="/user", headers = "Accept=application/json", method= RequestMethod.POST)
    public String send(@ModelAttribute("user") User user, Model model) {
        logger.info(user);
        model.addAttribute("user", user);
        user.addMessagesToMap();
        rabbitTemplate.convertAndSend(Constants.EXCHANGE, Constants.ROUTING_KEY, user.getMessage());
        return "user-page";
    }
}
