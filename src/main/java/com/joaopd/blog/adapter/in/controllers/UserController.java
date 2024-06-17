package com.joaopd.blog.adapter.in.controllers;

import com.joaopd.blog.application.core.domain.User;
import com.joaopd.blog.application.core.dto.UserDTO;
import com.joaopd.blog.application.ports.in.UserServicePort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserServicePort service;

    UserController(UserServicePort service) {
        this.service = service;
    }

    @GetMapping
    User getUser(@RequestBody Request req ) {
        return this.service.findUserById(req.id());
    }

    record Request(String id) {};

    @PostMapping
    void postUser(@RequestBody UserDTO dto) {
        this.service.createUser(dto);
    }

}
