package com.example.ChatApplication.processors;

import com.example.ChatApplication.db.UserDAL;
import com.example.ChatApplication.model.MemberAccount;
import org.springframework.stereotype.Component;

@Component
public class Add {

    private final UserDAL userDAL;

    public Add(UserDAL userDAL) {
        this.userDAL = userDAL;
    }

    public boolean addUser(MemberAccount memberAccount) {
        try {
            userDAL.addNewUser(memberAccount);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}
