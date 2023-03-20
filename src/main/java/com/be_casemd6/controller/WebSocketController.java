package com.be_casemd6.controller;

import com.be_casemd6.model.Hello;
import com.be_casemd6.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    public void greeting(User user) throws Exception {
        simpMessagingTemplate.convertAndSend("/topic/public", new Hello(user.getName() +" : " + user.getMessage()));
    }
}
