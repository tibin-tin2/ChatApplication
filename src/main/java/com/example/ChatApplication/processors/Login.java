package com.example.ChatApplication.processors;

import com.example.ChatApplication.db.UserDAL;
import com.example.ChatApplication.model.MemberAccount;
import org.springframework.stereotype.Component;

@Component
public class Login {


    private final UserDAL userDAL;

    public Login(UserDAL userDAL) {
        this.userDAL = userDAL;
    }

    public boolean checkLogin(MemberAccount memberAccount) {
        MemberAccount ma = userDAL.getUserByUserName(memberAccount.getUsername());
        if (ma != null) {
            if (ma.getPassword().equals(memberAccount.getPassword())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;

    }
}
