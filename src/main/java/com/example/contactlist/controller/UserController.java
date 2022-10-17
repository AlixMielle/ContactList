package com.example.contactlist.controller;

import com.example.contactlist.controller.dto.CreateUser;
import com.example.contactlist.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signin")
    public String displaySignInForm() {
        return "signInForm";
    }

    @GetMapping("/signup")
    public String displaySignUpForm(Model model) {
        model.addAttribute("createUser", new CreateUser()); //ajout d'un attribut dans la vue pour utiliser tagForm
        return "signUpForm";
    }

    @PostMapping("/signup")
    public String signUp(@Valid CreateUser createUser, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("createUser", createUser); //ajout d'un attribut dans la vue pour utiliser tagForm
            return "signUpForm";
        } else {
            userService.register(createUser);
            return "redirect:/signin";
        }
    }
}
