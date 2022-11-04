package com.hello.java.domain.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
public class User {
    @Id
    private Long id;
    private String userName;
    private String password;

    @Builder
    public User(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }
}
