package com.dkkcorp.mybankapp.controller;

import com.dkkcorp.mybankapp.command.AccountCommand;
import com.dkkcorp.mybankapp.command.TransactionsCommand;
import com.dkkcorp.mybankapp.command.UserCommand;
import com.dkkcorp.mybankapp.domain.Transactions;
import com.dkkcorp.mybankapp.service.AccountService;
import com.dkkcorp.mybankapp.service.TransactionsService;
import com.dkkcorp.mybankapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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
        List<TransactionsCommand> transactionsCommandList=transactionsService.findAllTransact();
        model.addAttribute("user",userCommand);
        model.addAttribute("account",accountCommand);
        model.addAttribute("transaction",transactionsCommandList);
        return "/user/account";
    }

    @GetMapping("/user/{id}/{accountNo}/transaction/{type}'")
    public String makeTransaction(@PathVariable String id, @PathVariable String accountNo, @PathVariable String type, Model model){
        return "/user/maketransaction";
    }
}
