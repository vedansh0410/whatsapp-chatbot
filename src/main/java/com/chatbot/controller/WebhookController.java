package com.chatbot.controller;

import com.chatbot.dto.IncomingMessageDto;
import com.chatbot.dto.OutgoingMessageDto;
import com.chatbot.service.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebhookController {

    @Autowired
    private ChatbotService chatbotService;

    @PostMapping("/webhook")
    public ResponseEntity<OutgoingMessageDto> receiveMessage(@RequestBody IncomingMessageDto incomingDto) {
        OutgoingMessageDto response = chatbotService.processMessage(incomingDto);
        return ResponseEntity.ok(response);
    }
}
