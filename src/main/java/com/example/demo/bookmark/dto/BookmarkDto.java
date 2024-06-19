package com.example.demo.bookmark.dto;


import com.example.demo.board.dto.BoardDto;
import com.example.demo.board.dto.BoardResponseDto;
import com.example.demo.bookmark.entity.Bookmark;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookmarkDto {

    private Long id;
    private BoardResponseDto board;
    private Long userId;

    public static BookmarkDto fromEntity(Bookmark bookmark) {
        return BookmarkDto.builder()
                .id(bookmark.getId())
                .userId(bookmark.getUserId())
                .board(BoardResponseDto.fromEntity(bookmark.getBoard()))
                .build();
    }
}

