package com.tts.capstone.SmartShreveCity2.controller;

import com.tts.capstone.SmartShreveCity2.model.User;
import com.tts.capstone.SmartShreveCity2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AuthorizationController {

    private UserService userService;

    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/signup")
//    public String registration(Model model) {
//        User user = new User();
//        model.addAttribute("user",user);
//        return "registration";
//    }
    @GetMapping("/")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "/login";
    }

    @PostMapping("/signup")
    public String createNewUser(@Valid User user,
                                BindingResult bindingResult,
                                Model model) {

        User userExists = userService.findByUsername(user.getUsername());

        System.out.println(user);

        if (userExists != null) {
            bindingResult.rejectValue("username",
                    "error.user",
                    "Username is already taken");
        }
        if (!bindingResult.hasErrors()) {
            userService.saveNewUser(user);
            model.addAttribute("success",
                    "Sign up successful!");
            model.addAttribute("user", new User());
        }
        return "registration";
    }

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login(){
        return "login";}
}