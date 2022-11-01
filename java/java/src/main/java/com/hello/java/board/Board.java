package com.hello.java.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.juli.DateFormatCache;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String title;

    private String content;

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
