package com.example.demo.board.dto;

import com.example.demo.board.entity.Board;
import com.example.demo.coment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    private boolean isLikeBoard;

    public static BoardResponseDto fromEntity(Board board){
        return new BoardResponseDto(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                board.getIsLikeBoard()
        );
    }
}
