package com.example.ChatApplication.impl;

import com.example.ChatApplication.db.MemberAccountDAL;
import com.example.ChatApplication.model.MemberAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberAccountDALImpl implements MemberAccountDAL {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<MemberAccount> getAllUsers() {
        return mongoTemplate.findAll(MemberAccount.class);
    }

    @Override
    public MemberAccount getUserByUserName(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        return mongoTemplate.findOne(query, MemberAccount.class);
    }

    @Override
    public MemberAccount addNewUser(MemberAccount memberAccount) {
        mongoTemplate.save(memberAccount);
        return memberAccount;
    }

    @Override
    public final String fetchUserIdFromUserName(MemberAccount memberAccount) {
        MemberAccount ma = getUserByUserName(memberAccount.getUsername());
        return ma != null ? ma.getUserId() : null;
    }

    @Override
    public MemberAccount getUserById(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        return mongoTemplate.findOne(query, MemberAccount.class);
    }
}
