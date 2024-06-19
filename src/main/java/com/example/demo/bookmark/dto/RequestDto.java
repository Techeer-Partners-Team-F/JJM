package com.example.demo.bookmark.dto;

import com.example.demo.board.dto.BoardDto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    private Long id;
    private BoardDto board;
    private Long userId;
}
