package com.example.demo.board.dto;

import com.example.demo.board.entity.Board;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardRequestDto {
    private String title;
    private String content;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
}
