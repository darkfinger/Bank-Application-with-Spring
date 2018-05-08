package com.dkkcorp.mybankapp.controller;

import com.dkkcorp.mybankapp.command.AccountCommand;
import com.dkkcorp.mybankapp.command.UserCommand;
import com.dkkcorp.mybankapp.domain.Transactions;
import com.dkkcorp.mybankapp.service.AccountService;
import com.dkkcorp.mybankapp.service.TransactionsService;
import com.dkkcorp.mybankapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AccountController {

    UserService userService;
    AccountService accountService;
    TransactionsService transactionsService;

    public AccountController(UserService userService, AccountService accountService, TransactionsService transactionsService) {
        this.userService = userService;
        this.accountService = accountService;
        this.transactionsService = transactionsService;
    }

    @GetMapping("/user/{id}/{accountNo}/accountDetails")
    public String showAccountDetail(@PathVariable String id,@PathVariable String accountNo, Model model){
        AccountCommand accountCommand=accountService.findAccount(Long.valueOf(accountNo));
        UserCommand userCommand=userService.findUser(Long.valueOf(id));
        model.addAttribute("user",userCommand);
        model.addAttribute("account",accountCommand);
        return "/user/account";
    }
}
