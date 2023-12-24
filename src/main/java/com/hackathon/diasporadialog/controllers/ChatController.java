package com.hackathon.diasporadialog.controllers;

import com.hackathon.diasporadialog.domain.entities.MessageEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public MessageEntity receiveMessage(@Payload MessageEntity message) {
        return message;
    }

    @MessageMapping("/private-message")
    public MessageEntity recMessage(@Payload MessageEntity message) {
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);
        System.out.println(message.toString());
        return message;
    }
}
