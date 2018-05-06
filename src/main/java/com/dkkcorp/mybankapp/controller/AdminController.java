package com.dkkcorp.mybankapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/{id}")
    public String userHome(){

        return "/admin/index";
    }
}
