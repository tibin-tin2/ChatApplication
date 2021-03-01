package com.example.ChatApplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Message {

    @Id
    private String messageId;
    private String sender;
    private String receiver;
    private String message;
    private String time;
    private Boolean isRead;

}
