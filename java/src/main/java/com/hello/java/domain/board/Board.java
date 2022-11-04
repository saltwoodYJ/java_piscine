package com.hello.java.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title") // 데이터베이스 이름 표기법!
    private String title;
    @Column(name = "content")
    private String content;
//    @Column(name = "createDate")
//    private LocalDateTime createDate;

    @Column
    private Long views;
    @Column
    private Long fame;

    @Builder

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
        this.views = 0L;
        this.fame = 0L;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long viewUp()
    {
        return this.views = this.views - 1L;
    }

    public Long fameUp()
    {
        return this.fame = this.fame + 1L;
    }

    public Long fameDown()
    {
        return this.fame = this.fame - 1L;
    }
}
