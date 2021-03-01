package com.example.ChatApplication.db;

import com.example.ChatApplication.model.MemberAccount;

import java.util.List;

public interface UserDAL {

    List<MemberAccount> getAllUsers();

    MemberAccount getUserByUserName(String username);

    MemberAccount addNewUser(MemberAccount memberAccount);

    String fetchUserIdFromUserName(MemberAccount memberAccount);

    MemberAccount getUserById(String userId);

}
