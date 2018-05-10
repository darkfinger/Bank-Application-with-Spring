package com.dkkcorp.mybankapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransactionController {

    @PostMapping("/user/{id}/{accountNo}/{type}/transactionload")
    public String transactionProcess(){
        return "redirect:/user/account";
    }
}
