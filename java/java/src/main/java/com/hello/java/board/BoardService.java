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

    public Optional<Board> update(Optional<Board> board, String name, String title, String content)
    {
        Board newBoard = board.get();
        if (name != null)
            newBoard.setName(name);
        if (title != null)
            newBoard.setTitle(title);
        if (content != null)
            newBoard.setContent(content);
        repository.save(newBoard);
        return board;
    }


}
