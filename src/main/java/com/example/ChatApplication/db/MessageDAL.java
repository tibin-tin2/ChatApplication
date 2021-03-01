package com.example.ChatApplication.db;

import com.example.ChatApplication.model.Message;

import java.util.List;

public interface MessageDAL {

    Message sendMessage(Message message);

    List<Message> getAllMessages();

    List<Message> getAllMessagesByReceiverName(String receiverName);
}
