package com.example.demo.coment.entity;


import com.example.demo.board.entity.Board;
import com.example.demo.coment.dto.CommentDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String coment;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder
    public Comment(Long id, String coment) {
        this.id = id;
        this.coment = coment;
    }

    public void update(CommentDto commentDto) {
        this.coment = commentDto.getComment();
    }
}
