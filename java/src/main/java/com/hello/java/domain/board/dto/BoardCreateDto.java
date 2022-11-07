package com.hello.java.domain.board.dto;


import com.hello.java.domain.board.Board;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
public class BoardCreateDto {
    private String title;
    private String content;
    private Long views;
    private Long fame;

    @Builder
    public BoardCreateDto(String title, String content)
    {
        this.title = title;
        this.content = content;
    }

    public Board toEntity()
    {
        return Board.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
}
