package com.dkkcorp.mybankapp.controller;

import com.dkkcorp.mybankapp.command.AccountCommand;
import com.dkkcorp.mybankapp.command.UserCommand;
import com.dkkcorp.mybankapp.domain.Account;
import com.dkkcorp.mybankapp.service.AccountService;
import com.dkkcorp.mybankapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    UserService userService;
    AccountService accountService;

    public UserController(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @GetMapping("/user/{id}")
    public String userHome(@PathVariable String id, Model model) {
        List<AccountCommand> accountCommandArrayList;
        accountCommandArrayList = accountService.findByUserId(Long.valueOf(id));
        UserCommand userCommand=userService.findUser(Long.valueOf(id));
        model.addAttribute("user",userCommand);
        model.addAttribute("account", accountCommandArrayList);
        return "/user/index";
    }
    @GetMapping("/user/{id}/myAccount")
    public String userDetail(@PathVariable String id,Model model){
        List<AccountCommand> accountCommandArrayList;
        accountCommandArrayList = accountService.findByUserId(Long.valueOf(id));
        UserCommand userCommand=userService.findUser(Long.valueOf(id));
        model.addAttribute("user",userCommand);
        model.addAttribute("account", accountCommandArrayList);
        return "/user/profile";
    }
    @PostMapping("/user/{id}/myAccount/editprofile")
    public  String editProfile(@PathVariable String id,@ModelAttribute UserCommand user, Model model){
        List<AccountCommand> accountCommandArrayList;
        accountCommandArrayList = accountService.findByUserId(Long.valueOf(id));
        UserCommand userCommand=userService.findUser(Long.valueOf(id));
        userCommand.setFirstName(user.getFirstName());
        userCommand.setLastName(user.getLastName());
        userCommand.setEmail(user.getEmail());
        UserCommand userSaved=userService.saveUser(userCommand);
        model.addAttribute("user",userSaved);
        model.addAttribute("account", accountCommandArrayList);
        return "/user/profile";
    }
}
