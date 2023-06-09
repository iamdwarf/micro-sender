package com.micro.microsender.controller;

import com.micro.microsender.MicroSenderApplication;
import com.micro.microsender.model.User;
import com.micro.microsender.service.SenderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SenderController {

    @Autowired
    private SenderService senderService;

    private static final Logger logger = LogManager.getLogger(MicroSenderApplication.class);

    @RequestMapping(value="/user", method= RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("user", new User());
        logger.info("new user data was sent");
        return "user-form";
    }

    @RequestMapping(value="/user", headers = "Accept=application/json", method= RequestMethod.POST)
    public String send(@ModelAttribute User user, Model model){
        logger.info(user);
        model.addAttribute("user", user);
        senderService.sendMessage(user);
        logger.info(user.getMessage(), " is sent" );
        return "user-page";
    }

}
