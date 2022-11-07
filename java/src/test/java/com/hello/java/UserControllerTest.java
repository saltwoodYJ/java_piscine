package com.hello.java;

import com.hello.java.domain.board.User;
import com.hello.java.domain.board.UserRepository;
import com.hello.java.domain.board.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    public void addOne(){
        //given
        String name = "yejinam";
        String password = "4242";

        //when
        Long id = userRepository.save(User.builder()
                .userName(name)
                .password(password)
                .build()).getId();

        //then

    }

}
