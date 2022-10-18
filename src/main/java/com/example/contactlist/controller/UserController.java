package com.example.contactlist.controller;

import com.example.contactlist.controller.dto.CreateUser;
import com.example.contactlist.repository.entity.User;
import com.example.contactlist.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

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
        model.addAttribute("createUser", new CreateUser());
        return "signUpForm";
    }

    @PostMapping("/signup")
    public String signUp(@Valid CreateUser createUser, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("createUser", createUser);
            return "signUpForm";
        } else {
            userService.register(createUser);
            return "redirect:/signin";
        }
    }


    @GetMapping("/edit/{id}")
    public String editUSerForm(@PathVariable("id") long id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "editUserForm";
    }

    @PostMapping ("/edit/{id}")
    public RedirectView editContact(@PathVariable("id") long id, CreateUser editUser){
        userService.editUser(id,editUser);
        return new RedirectView("/detailsUser/" + id);
    }

    @GetMapping("/detailsUser/{id}")
    public String displayProfile(@PathVariable("id") long id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "detailProfileView";
    }
}
