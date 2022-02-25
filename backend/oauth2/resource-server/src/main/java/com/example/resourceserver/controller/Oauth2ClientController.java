package com.example.resourceserver.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class Oauth2ClientController {
    @GetMapping("/welcome")
    public ModelAndView welcome() {
        return new ModelAndView("welcome");
    }

    @GetMapping("/api/user")
    @PreAuthorize("hasAuthority('USER')")
    public Map<String, Object> apiUser() {
        return null;
    }

    @GetMapping("/api/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Map<String, Object> apiAdmin() {
        return null;
    }

    @GetMapping("/api/root")
    @PreAuthorize("hasAuthority('ROOT')")
    public Map<String, Object> apiRoot() {
        return null;
    }
}
