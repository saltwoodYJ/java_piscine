package com.hello.java;

import com.hello.java.domain.board.Board;
import com.hello.java.domain.board.BoardRepository;
import com.hello.java.domain.board.BoardService;
import com.hello.java.domain.board.dto.BoardCreateDto;
import com.hello.java.domain.board.dto.BoardListResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class BoardControllerTest {
    @Autowired
    BoardService boardService;
    @Autowired
    BoardRepository boardRepository;


    @Test
    public void findOne() {

        //given
        Board test1 = new Board();
//        test1.setTitle("hi");
//        test1.setContent("hello");

        //when
        Long id = boardRepository.save(test1).getId();


        //then

        Optional<Board> findBoard = boardService.findOne(id);

        Assertions.assertThat(test1.getTitle()).isEqualTo(findBoard.get().getTitle());
        Assertions.assertThat(test1.getContent()).isEqualTo(findBoard.get().getContent());

//        BoardListResponseDto testDto = boardService.findBoards();


//        assertThat(testDto.getBoardList()).isEqualTo(boardRepository.findAll());
//        assertThat(testDto.getCount()).isEqualTo(boardRepository.findAll().size());


    }

    @Test
    public void updateBoard() {
        //Given
        Board test1 = new Board();
//        test1.setTitle("42");
//        test1.setContent("GG");
        Long id1 = boardRepository.save(test1).getId();

        //when
        test1.update("Ping", "Pong");


        //then
        Optional<Board> test2 = boardService.findOne(id1);
        Optional<Board> findBoard = boardService.findOne(id1);

        Assertions.assertThat(test2.get().getTitle()).isEqualTo(findBoard.get().getTitle());
        Assertions.assertThat(test2.get().getContent()).isEqualTo(findBoard.get().getContent());

    }

    @Test
    public void findBoards() {
        //Given
        Board test1 = new Board();
        Board test2 = new Board();
//        test1.setTitle("42");
//        test1.setContent("GG");
//        test2.setTitle("PING");
//        test2.setContent("PONG");
        boardRepository.save(test1);
        boardRepository.save(test2);


        //when
        System.out.println("1");
        List<Board> boardList = boardRepository.findAll();
        System.out.println("2");
        int boardCnt = boardList.size();

        //then
        BoardListResponseDto findDto = boardService.findBoards();

        Assertions.assertThat(boardList.get(1).getContent()).isEqualTo(findDto.getBoardList().get(1).getContent());
        Assertions.assertThat(boardList.get(2).getTitle()).isEqualTo(findDto.getBoardList().get(2).getTitle());
        Assertions.assertThat(boardCnt).isEqualTo(findDto.getCount());

    }

    @Test
    @Transactional
    public void viewBoards() {
        //Given
        String title1 = "42";
        String content1 = "GG";
        String title2 = "Back";
        String content2 = "front";


        Long id1 = boardRepository.save(BoardCreateDto.builder()
                .title(title1)
                .content(content1)
                .build().toEntity()).getId();
        Long id2 = boardRepository.save(BoardCreateDto.builder()
                .title(title2)
                .content(content2)
                .build().toEntity()).getId();
//        Board test1 = new Board();
//        Board test2 = new Board();
//        boardService.findOne(id1);
//        Integer view1 = boardRepository.findById(id1).get().getViews();
//        System.out.println(view1);


        //when
        boardService.findOne(id1);
        boardService.findOne(id1);
        boardService.findOne(id1);
        boardService.findOne(id1);
        boardService.findOne(id2);
        boardService.findOne(id2);

        //then
        Long view1 = boardRepository.findById(id1).get().getViews();
        Long view2 = boardRepository.findById(id2).get().getViews();

        Assertions.assertThat(4L).isEqualTo(view1);
        Assertions.assertThat(2L).isEqualTo(view2);
    }


    @Test
    public void fameCheck(){
        //Given
        String title1 = "42";
        String content1 = "GG";
        String title2 = "Back";
        String content2 = "Front";

        Long id1 = boardRepository.save(BoardCreateDto.builder()
                .title(title1)
                .content(content1)
                .build().toEntity()).getId();
        Long id2 = boardRepository.save(BoardCreateDto.builder()
                .title(title2)
                .content(content2)
                .build().toEntity()).getId();

        //When
        boardService.fameUp(id1);
        boardService.fameUp(id1);
        boardService.fameUp(id1);
        boardService.fameUp(id1);
        boardService.fameDown(id1);
        boardService.fameDown(id1);
        boardService.fameDown(id2);
        boardService.fameDown(id2);
        boardService.fameDown(id2);
        boardService.fameDown(id2);
        boardService.fameDown(id2);



        //Then
        Long fame1 = boardRepository.findById(id1).get().getFame();
        Long fame2 = boardRepository.findById(id2).get().getFame();

        Assertions.assertThat(2L).isEqualTo(fame1);
        Assertions.assertThat(-5L).isEqualTo(fame2);

    }

}