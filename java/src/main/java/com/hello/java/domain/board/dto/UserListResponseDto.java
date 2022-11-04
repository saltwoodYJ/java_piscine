package com.hello.java.domain.board.dto;

import com.hello.java.domain.board.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class UserListResponseDto {
    private List<User> userList;
    private int userCount;

    @Builder
    public UserListResponseDto(List<User> userList, int userCount){
        this.userList = userList;
        this.userCount = userCount;
    }
}
