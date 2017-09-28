package com.goloveschenko.site.controller;

import com.goloveschenko.site.entity.User;
import com.goloveschenko.site.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userList", userService.getAllUsers());

        return "users";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        if (user.getId() == 0) {
            userService.addUser(user);
        } else {
            userService.updateUser(user);
        }

        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);

        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("userList", userService.getAllUsers());

        return "users";
    }

    @GetMapping("/data/{id}")
    public String userData(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));

        return "data";
    }
}
