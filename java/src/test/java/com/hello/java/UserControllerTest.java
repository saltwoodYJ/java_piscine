package com.hello.java;

import com.hello.java.domain.board.User;
import com.hello.java.domain.board.UserRepository;
import com.hello.java.domain.board.UserService;
import com.hello.java.domain.board.dto.UserListResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    public void 유저찾기(){
        //given
        String name = "name";
        String password = "password";
        User userAdd = User.builder()
                .userName(name)
                .password(password)
                .build();
        userService.addUser(name, password);

        //when
        User getUser = userService.findUserOne("name");

        //then
        Assertions.assertThat(name).isEqualTo(getUser.getUserName());
        Assertions.assertThat(password).isEqualTo(getUser.getPassword());

    }

    @Test
    public void 유저중복체크(){
        //given
        String name = "name";
        String password = "password";
        User userAdd = User.builder()
                .userName(name)
                .password(password)
                .build();
        userRepository.save(userAdd);

        //when
        boolean not = userService.isNotExist(name);
        boolean is = userService.isNotExist("not");

        //then
        Assertions.assertThat(false).isEqualTo(not);
        Assertions.assertThat(true).isEqualTo(is);

    }


}
