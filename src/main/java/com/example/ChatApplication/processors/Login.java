package com.example.ChatApplication.processors;

import com.example.ChatApplication.db.MemberAccountDAL;
import com.example.ChatApplication.model.MemberAccount;
import org.springframework.stereotype.Component;

@Component
public class Login {


    private final MemberAccountDAL memberAccountDAL;

    public Login(MemberAccountDAL memberAccountDAL) {
        this.memberAccountDAL = memberAccountDAL;
    }

    public boolean checkLogin(MemberAccount memberAccount) {
        MemberAccount ma = memberAccountDAL.getUserByUserName(memberAccount.getUsername());
        if (ma != null) {
            if (ma.getPassword().equals(memberAccount.getPassword())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;

    }
}
