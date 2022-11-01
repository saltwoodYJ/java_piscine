package com.hello.java.board;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //json형태로 데이터 반환
@AllArgsConstructor //생성자
public class BoardController {
    public BoardService boardService;

    @PostMapping("/board")
    public Board save() {
        Board board = new Board("title", "content");
        return boardService.save(board);
    }




}
