package com.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(String username, String password, Model model, HttpSession httpSession){
        if (!username.isEmpty()&& "123456".equals(password)){
            httpSession.setAttribute("loginUser",username);
            return "redirect:main.html";
        }
        model.addAttribute("msg","用户名或密码错误");
        return "index";
    }
}
