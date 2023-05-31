package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

@RequestMapping("/admin")
@Controller
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("usersList", userService.allUsers());
        return "users";
    }

    @GetMapping("/addUser")
    public String getUserInputForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "addUser";
    }

    @PostMapping(value = "/users")
    public String addNewUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/edit/{id}")
    public String getUserUpdateFormById(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id).get());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "edit";
    }

    @PatchMapping(value = "/{id}")
    public String updateUserById(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.edit(user, id);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable(value = "id") long id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }
}
