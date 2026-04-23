package com.chatbot.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;

    @Column(name="incoming_message")
    private String incomingMessage;

    @Column(name="outgoing_message")
    private String outgoingMessage;

    @Column(name="received_at")
    private LocalDateTime receivedAt;

    public Message() {}

    public Message(String sender,String incomingMessage,String outgoingMessage,LocalDateTime receivedAt){
        this.sender=sender;
        this.incomingMessage=incomingMessage;
        this.outgoingMessage=outgoingMessage;
        this.receivedAt=receivedAt;
    }

    public Long getId(){return id;}
    public String getSender(){return sender;}
    public void setSender(String sender){this.sender=sender;}
    public String getIncomingMessage(){return incomingMessage;}
    public void setIncomingMessage(String incomingMessage){this.incomingMessage=incomingMessage;}
    public String getOutgoingMessage(){return outgoingMessage;}
    public void setOutgoingMessage(String outgoingMessage){this.outgoingMessage=outgoingMessage;}
    public LocalDateTime getReceivedAt(){return receivedAt;}
    public void setReceivedAt(LocalDateTime receivedAt){this.receivedAt=receivedAt;}
}