package com.dkkcorp.mybankapp.controller;

import com.dkkcorp.mybankapp.command.TransactionsCommand;
import com.dkkcorp.mybankapp.domain.Transactions;
import com.dkkcorp.mybankapp.service.TransactionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransactionController {
    TransactionsService transactionsService;

    public TransactionController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @PostMapping("/user/{id}/{accountNo}/{type}/transactionload")
    public String transactionProcess(Model model,@PathVariable String id, @PathVariable String accountNo, @PathVariable String type, @ModelAttribute TransactionsCommand transactionsCommand){
        TransactionsCommand transactionsCommandSaved=transactionsService.makeTransact(transactionsCommand);
        model.addAttribute("transaction",transactionsCommandSaved);
        return "redirect:/user/"+id+"/"+accountNo+"/accountDetails";
    }
}
