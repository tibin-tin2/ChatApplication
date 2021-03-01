package com.example.ChatApplication.controller;

import com.example.ChatApplication.model.MemberAccount;
import com.example.ChatApplication.processors.Add;
import com.example.ChatApplication.processors.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RouteMapper {

    @Autowired
    Add add;

    @Autowired
    Login login;

    @GetMapping("/login")
    public String getLoginDet(MemberAccount memberAccount) {
        return "login";
    }

    @PostMapping("/login")
    public String viewLogin(@ModelAttribute MemberAccount memberAccount) {
        if (login.checkLogin(memberAccount)) {
            return "viewUser";
        }
        return "login";
    }

    @GetMapping("/add")
    public String createAccount(MemberAccount memberAccount) {
        return "createAccount";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addUser(@ModelAttribute MemberAccount memberAccount) {
        add.addUser(memberAccount);
        return "user created";
    }

//    @GetMapping("/view")
//    @ResponseBody
//    public List<User> getAllUsers() {
//        return userDAL.getAllUsers();
//    }
//
//    @PostMapping("/add")
//    public User addUser(@RequestBody User user) {
//        return userDAL.addNewUser(user);
//    }
//
//    @GetMapping("/view/username={username}")
//    public User getUser(@PathVariable String username) {
//        return userDAL.getUserByName(username);
//    }

}



