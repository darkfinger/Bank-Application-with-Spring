package com.dkkcorp.mybankapp.controller;

import com.dkkcorp.mybankapp.command.UserAddressCommand;
import com.dkkcorp.mybankapp.command.UserCommand;
import com.dkkcorp.mybankapp.command.UserContactCommand;
import com.dkkcorp.mybankapp.service.AdminService;
import com.dkkcorp.mybankapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    AdminService adminService;
    UserService userService;

    public AdminController(AdminService adminService,UserService userService) {
        this.adminService = adminService;
        this.userService=userService;
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
    @PostMapping("/bank-admin/{id}/operations")
    public String addUserStep2(@PathVariable String id, Model model, @ModelAttribute UserCommand userCommand){
        UserCommand userCommandSaved=userService.saveUser(userCommand);
        model.addAttribute("admin",adminService.findAdmin(Long.valueOf(id)));
        model.addAttribute("userId",userCommandSaved.getId());
        model.addAttribute("contact",new UserContactCommand());

        return "redirect:/admin/add-user";
    }

}
