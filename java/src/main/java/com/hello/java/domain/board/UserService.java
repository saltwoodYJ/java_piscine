package com.hello.java.domain.board;

import com.hello.java.domain.board.dto.UserListResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserListResponseDto findUserAll(){
        List<User> userList = userRepository.findAll();
        UserListResponseDto userListResponseDto = UserListResponseDto.builder()
                .userList(userList)
                .userCount(userList.size())
                .build();
        return userListResponseDto;
    }
    public boolean isNotExist(String userName)
    {
        List<User> userList = findUserAll().getUserList();
        for (User user : userList) {
            if (user.getUserName().equals(userName))
                return false;
        }
        return true;
    }

    public User findUserOne(String userName)
    {
        List<User> userList = findUserAll().getUserList();
        for (User user : userList) {
            if (user.getUserName().equals(userName))
                return user;
        }
        return null;
    }

    public boolean addUser(String userName, String password) {
        if (findUserOne(userName) == null) {
            userRepository.save(User.builder()
                    .userName(userName)
                    .password(password)
                    .build());
            return true;
        }
        return false;
    }
}