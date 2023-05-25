package ru.kata.spring.boot_security.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.configs.WebSecurityConfig;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;
import java.util.Set;

@Controller
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping("/user")
    public String infoUser(Model model) {
        model.addAttribute("user",
                userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
        return "userinfo";
    }

    @GetMapping("/admin/users")
    public String allUsers(Model model) {
        model.addAttribute("usersList", userService.allUsers());
        return "users";
    }

    @GetMapping("/admin/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "addUser";
    }

    @PostMapping(value = "/admin/users")
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/edit/{id}")
    public String update(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id).get());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "edit";
    }

    @PatchMapping(value = "/admin/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.edit(user, id);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/admin/{id}")
    public String delete(@PathVariable(value = "id") long id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }
}
