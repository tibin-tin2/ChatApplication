package com.example.ChatApplication.processors;

import com.example.ChatApplication.db.MemberAccountDAL;
import com.example.ChatApplication.model.MemberAccount;
import org.springframework.stereotype.Component;

@Component
public class Add {

    private final MemberAccountDAL memberAccountDAL;

    public Add(MemberAccountDAL memberAccountDAL) {
        this.memberAccountDAL = memberAccountDAL;
    }

    public boolean addUser(MemberAccount memberAccount) {
        try {
            memberAccountDAL.addNewUser(memberAccount);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}
