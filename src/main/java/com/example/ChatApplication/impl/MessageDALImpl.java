package com.example.ChatApplication.impl;

import com.example.ChatApplication.db.MessageDAL;
import com.example.ChatApplication.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDALImpl implements MessageDAL {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public Message sendMessage(Message message) {
        mongoTemplate.save(message);
        return message;
    }

    @Override
    public List<Message> getAllMessages() {
        return mongoTemplate.findAll(Message.class);
    }

    @Override
    public List<Message> getAllMessagesByReceiverName(String receiverName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("receiver").is(receiverName));
        return mongoTemplate.find(query, Message.class);
    }
}
