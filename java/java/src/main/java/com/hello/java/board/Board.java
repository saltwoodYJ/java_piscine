package com.hello.java.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.juli.DateFormatCache;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String title;

    private String content;

    @Builder
    public Board(String name, String title, String content) {
        this.title = title;
        this.content = content;
        this.name = name;
    }

    public void update(String name, String title, String content) {
        this.setName(name);
        this.setTitle(title);
        this.setContent(content);
    }
}
