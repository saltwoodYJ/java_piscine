package com.hello.java.board;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {
    private BoardRepository repository;

    public Board save(Board board) {
        Board newBoard = new Board(board.getTitle(), board.getContent(), board.getName());
        //Dto
        newBoard = repository.save(board);

        return newBoard;
    }

    public Optional<Board> find(Long id) {
        return repository.findById(id);
    }


}
