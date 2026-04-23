package com.chatbot.service;

import com.chatbot.dto.IncomingMessageDto;
import com.chatbot.dto.OutgoingMessageDto;
import com.chatbot.model.Message;
import com.chatbot.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChatbotService {

    private static final Logger logger = LoggerFactory.getLogger(ChatbotService.class);

    @Autowired
    private MessageRepository messageRepository;

    public OutgoingMessageDto processMessage(IncomingMessageDto incomingDto) {
        String sender = incomingDto.getSender();
        String text = incomingDto.getMessage();

        // Log all incoming messages
        logger.info("Incoming message from [{}]: {}", sender, text);

        // Predefined replies
        String reply;
        String normalized = text == null ? "" : text.trim().toLowerCase();

        if (normalized.equals("hi")) {
            reply = "Hello";
        } else if (normalized.equals("bye")) {
            reply = "Goodbye";
        } else {
            reply = "I don't understand that message.";
        }

        // Save to database
        Message message = new Message(sender, text, reply, LocalDateTime.now());
        messageRepository.save(message);

        logger.info("Replied to [{}]: {}", sender, reply);

        return new OutgoingMessageDto(sender, reply);
    }
}
