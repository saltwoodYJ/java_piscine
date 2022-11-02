package com.hello.java.board;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController //json형태로 데이터 반환
@AllArgsConstructor //생성자
public class BoardController {
    public BoardService boardService;

    @PostMapping("/board")
    public Board save(@RequestParam("name") String name,
                      @RequestParam(value = "title", required = false) String title,
                      @RequestParam(value = "content", required = false) String content) {
        Board board = new Board(name, title, content);
        return boardService.save(board);
    }

    @GetMapping("/board")
    public Optional<Board> find(@RequestParam("id") Long id){
        Optional<Board> board = boardService.find(id);
        return board;
    }

    @PutMapping("/board")
    public Optional<Board> update(@RequestParam(value = "id") Long id,
                                  @RequestParam(value = "name") String name,
                                  @RequestParam(value = "title") String title,
                                  @RequestParam(value = "content") String content) {
        Optional<Board> board = boardService.find(id);
        return boardService.update(board, name, title, content);
    }

    @DeleteMapping("/board")
    public void delete(Long id) {
        boardService.delete(id);
    }

}
