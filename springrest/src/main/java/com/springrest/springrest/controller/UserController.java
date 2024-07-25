package com.springrest.springrest.controller;

import com.springrest.springrest.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user, Model model) {
        // logic to create user
        model.addAttribute("user", user);
        return "userCreated";
    }

//    @GetMapping("/{id}")
//    public String getUser(@PathVariable Long id, Model model) {
//        // logic to fetch user by id
//        User user = userService.findById(id);
//        model.addAttribute("user", user);
//        return "userDetails";
//    }
}