package com.hello.java.domain.board.dto;

import com.hello.java.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class BoardListResponseDto {
    private List<Board> boardList;
    private int count;

    @Builder
    public BoardListResponseDto(List boardList, int count) {
        this.boardList = boardList;
        this.count = count;
    }
}
