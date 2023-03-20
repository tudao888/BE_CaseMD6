package com.be_casemd6.controller;

import com.be_casemd6.model.Account;
import com.be_casemd6.model.Hello;
import com.be_casemd6.model.User;
import com.be_casemd6.model.dto.NotificationDTO;
import com.be_casemd6.service.impl.AccountService;
import com.be_casemd6.service.impl.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@CrossOrigin("*")
public class WebSocketController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private NotificationService notificationService;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    public void greeting(User user) throws Exception {
        simpMessagingTemplate.convertAndSend("/topic/public", new Hello(user.getName() +" : " + user.getMessage()));
    }

    @GetMapping("/notificationDTO")
    public ResponseEntity<List<NotificationDTO>> showNotification() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findAccountByUsername(userDetails.getUsername());
        List<NotificationDTO> notificationDTOS = notificationService.showNotification(account.getId());
        return new ResponseEntity<>(notificationDTOS, HttpStatus.OK);
    }

}
