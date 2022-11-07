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

    @Test
    public void 유저리스트찾기(){
        String name1 = "name1";
        String password1 = "password";
        User userAdd1 = User.builder()
                .userName(name1)
                .password(password1)
                .build();
        String name2 = "name2";
        String password2 = "password";
        User userAdd2 = User.builder()
                .userName(name2)
                .password(password2)
                .build();
        userRepository.save(userAdd1);
        userRepository.save(userAdd2);
        UserListResponseDto userListResponseDto = UserListResponseDto.builder()
                .userList(userRepository.findAll())
                .userCount(userRepository.findAll().size())
                .build();

        //when
        UserListResponseDto getDto = userService.findUserAll();

        //then
        Assertions.assertThat(userListResponseDto.getUserCount()).isEqualTo(getDto.getUserCount());
        Assertions.assertThat(userListResponseDto.getUserList().get(1).getUserName())
                .isEqualTo(getDto.getUserList().get(1).getUserName());
        Assertions.assertThat(userListResponseDto.getUserList().get(1).getPassword())
                .isEqualTo(getDto.getUserList().get(1).getPassword());


    }


}
