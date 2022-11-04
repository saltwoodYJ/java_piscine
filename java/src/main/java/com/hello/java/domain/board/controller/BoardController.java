package com.hello.java.domain.board.controller;


import com.hello.java.domain.board.Board;
import com.hello.java.domain.board.BoardService;
import com.hello.java.domain.board.dto.BoardUpdateDto;
import com.hello.java.domain.board.dto.BoardListResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/board")
    public Board saveBaord(@RequestParam("title") String title,
                           @RequestParam("content") String content) {
        Board board = new Board(title, content);
        return boardService.save(board);
    }

    @GetMapping("/board/{boardId}")
    public Board findBoard(@PathVariable("boardId") Long boardId) {
        Board findBoard = boardService.findOne(boardId).orElseThrow();
        return findBoard;
    }

    @GetMapping("/board")
    public BoardListResponseDto findBoards() {
        BoardListResponseDto boardList = boardService.findBoards();
        return boardList;
    }

    @PutMapping("/board/{boardId}")
    public Long updateBoard(@PathVariable("boardId") Long boardId, @RequestBody BoardUpdateDto boardUpdateDto) {
        return boardService.update(boardId, boardUpdateDto);
    }

    @PutMapping("/board/{boardId}/{UpDown}")
    public Long fameUpDown(@PathVariable("boardId") Long boardId, @PathVariable("UpDown") Long UpDown) {
        Long fame = 0L;
        if (UpDown == 1)
            fame = boardService.fameUp(boardId);
        else if(UpDown == 0)
            fame = boardService.fameDown(boardId);
        return fame;
    }

    @DeleteMapping("/board")
    public void delete(@RequestParam Long boardId) {
        boardService.delete(boardId);
    }

}
