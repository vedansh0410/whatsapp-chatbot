package com.chatbot.dto;

public class IncomingMessageDto {

    private String sender;
    private String message;

    public IncomingMessageDto() {}

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
