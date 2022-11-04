package com.hello.java.domain.board.controller;

import com.hello.java.domain.board.User;
import com.hello.java.domain.board.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {
    UserService userService;

    @PostMapping("/user")
    public boolean addUser(@RequestParam("userId") String userId, @RequestParam("password") String password) {
        return userService.addUser(userId, password);
    }

}
