package com.example.demo.board.dto;

import com.example.demo.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;

    public static BoardResponseDto fromEntity(Board board){
        return new BoardResponseDto(
                board.getId(),
                board.getTitle(),
                board.getContent()
        );
    }
}
