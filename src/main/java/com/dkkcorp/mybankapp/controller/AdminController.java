package com.dkkcorp.mybankapp.controller;

import com.dkkcorp.mybankapp.command.UserCommand;
import com.dkkcorp.mybankapp.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {
    AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/bank-admin/login")
    public String adminLogin(){

        return "/admin/index";
    }
    @GetMapping("/bank-admin/{id}/dashboard/")
    public String adminHome(@PathVariable String id, Model model){
        model.addAttribute("admin",adminService.findAdmin(Long.valueOf(id)));
        model.addAttribute("accountList",adminService.findAllAccount());
        model.addAttribute("userList",adminService.findAllUser());
        return "/admin/main-panel";
    }

    @GetMapping("/bank-admin/{id}/add-user")
    public String addUser(@PathVariable String id, Model model){
        model.addAttribute("admin",adminService.findAdmin(Long.valueOf(id)));
        model.addAttribute("user",new UserCommand());

        return "/admin/add-user";
    }
}
