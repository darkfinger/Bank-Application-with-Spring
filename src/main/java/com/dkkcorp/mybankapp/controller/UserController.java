package com.dkkcorp.mybankapp.controller;

import com.dkkcorp.mybankapp.command.AccountCommand;
import com.dkkcorp.mybankapp.domain.Account;
import com.dkkcorp.mybankapp.service.AccountService;
import com.dkkcorp.mybankapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        List<AccountCommand> accountCommandArrayList = new ArrayList<>();
        accountCommandArrayList = accountService.findByUserId(Long.valueOf(id));
        model.addAttribute("account", accountCommandArrayList);
        return "/user/index";
    }
}
