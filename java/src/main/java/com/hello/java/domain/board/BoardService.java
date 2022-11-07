package com.hello.java.domain.board;

import com.hello.java.domain.board.dto.BoardListResponseDto;
import com.hello.java.domain.board.dto.BoardUpdateDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public BoardListResponseDto findBoards() {
        List<Board> boardList = boardRepository.findAll();
        BoardListResponseDto boardListResponseDto = BoardListResponseDto.builder()
                .boardList(boardList)
                .count(boardList.size())
                .build();
        return boardListResponseDto;
    }
    @Transactional
    public Long update(Long id, BoardUpdateDto boardUpdateDto) {
        Board board = findOne(id).orElseThrow();
        board.update(boardUpdateDto.getTitle(), boardUpdateDto.getContent(), boardUpdateDto.getTag());
        return id;
    }

    @Transactional
    public Optional<Board> findOne(Long boardId) {
        Optional<Board> board = boardRepository.findById(boardId);
        board.get().viewUp();
        return board;
    }



    public Long fameUp(Long id)
    {
        Board board = findOne(id).orElseThrow();
        return board.fameUp();
    }

    @Transactional

    public Long fameDown(Long id)
    {
        Board board = findOne(id).orElseThrow();
        return board.fameDown();
    }
    @Transactional
    public void delete(Long id) {
        Board board = boardRepository.findById(id).orElseThrow();
        boardRepository.delete(board);
    }
}
