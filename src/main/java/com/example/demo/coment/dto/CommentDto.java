package com.example.demo.coment.dto;

import com.example.demo.coment.entity.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentDto {
    private Long id;
    private String comment;

    public Comment toEntity() {
        return Comment.builder()
                .coment(comment)
                .build();
    }

    public static CommentDto fromEntity(Comment comment){
        return new CommentDto(
                comment.getId(),
                comment.getComent()
        );
    }
}
