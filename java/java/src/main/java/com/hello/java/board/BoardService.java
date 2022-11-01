package com.hello.java.board;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoardService {
    private BoardRepository repository;

    public Board save(Board board)
    {
        Board newBoard = new Board(board.getTitle(), board.getContent());
        return repository.save(board);
    }


}
