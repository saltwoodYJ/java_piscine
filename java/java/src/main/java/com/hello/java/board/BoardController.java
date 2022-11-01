package com.hello.java.board;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController //json형태로 데이터 반환
@AllArgsConstructor //생성자
public class BoardController {
    public BoardService boardService;

    @PostMapping("/board")
    public Board save(@RequestParam("name") String name) {
        Board board = new Board("title", "content", name);
        return boardService.save(board);
    }

    @GetMapping("/board")
    public Optional<Board> find(@RequestParam("id") Long id){
        Optional<Board> board = boardService.find(id);
        return board;
    }

//    @DeleteMapping("/board")
//    public Board delete()
//    {
//
//    }

}
