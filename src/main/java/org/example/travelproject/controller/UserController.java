package org.example.travelproject.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.travelproject.model.Role;
import org.example.travelproject.model.User;
import org.example.travelproject.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserService iUserRepository;

    @GetMapping("/log")
    public ModelAndView loginF() {
        ModelAndView modelAndView = new ModelAndView("log");
        modelAndView.addObject("newUser", new User());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request) {
        User userFind = iUserRepository.findByUser(email);
        ModelAndView modelAndView;
        if (userFind != null && userFind.getPassword().equals(password)) {
            Set<Role> roles = userFind.getRoles();
            boolean checkRole = false;
            for (Role role : roles) {
                if (role.getRoleId() == 1) {
                    checkRole = true;
                    break;
                }
            }
            if (checkRole) {
                modelAndView = new ModelAndView("redirect:/admin");
            } else {
                modelAndView = new ModelAndView("redirect:/travel");
            }
            HttpSession session = request.getSession();
            session.setAttribute("user", userFind);
        } else {
            modelAndView = new ModelAndView("redirect:/log");
        }
        return modelAndView;
    }

    @GetMapping("/signup")
    public ModelAndView registerF() {
        ModelAndView modelAndView = new ModelAndView("signupForm");
        modelAndView.addObject("newUser", new User());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(User user) {
        Role role = new Role(2);
        ModelAndView modelAndView = new ModelAndView("redirect:/log");
        if (user.getRoles().isEmpty()) {
            user.setRoles(Collections.singleton(role));
        }
        iUserRepository.save(user);
        return modelAndView;
    }

    @GetMapping("/getUser")
    public ModelAndView getUser(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("userDetail");
        HttpSession session = request.getSession();
        if (session != null) {
            User user = (User) session.getAttribute("user");
            modelAndView.addObject("user", user);
        }
        return modelAndView;
    }

    @GetMapping("/{id}/userOrder")
    public ModelAndView userOrder(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("userOrder");
        modelAndView.addObject("userOrder", iUserRepository.findById(id).get());
        return modelAndView;
    }



}

