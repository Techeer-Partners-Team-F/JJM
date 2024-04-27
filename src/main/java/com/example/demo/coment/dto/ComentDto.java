package com.example.demo.coment.dto;

import com.example.demo.board.dto.BoardResponseDto;
import com.example.demo.board.entity.Board;
import com.example.demo.coment.entity.Coment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ComentDto {
    private Long id;
    private String coment;

    public Coment toEntity() {
        return Coment.builder()
                .coment(coment)
                .build();
    }

    public static ComentDto fromEntity(Coment coment){
        return new ComentDto(
                coment.getId(),
                coment.getComent()
        );
    }
}
