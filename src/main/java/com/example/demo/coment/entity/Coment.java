package com.example.demo.coment.entity;


import com.example.demo.coment.dto.ComentDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Coment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String coment;

    @Builder
    public Coment(Long id, String coment) {
        this.id = id;
        this.coment = coment;
    }

    public void update(ComentDto comentDto) {
        this.coment = comentDto.getComent();
    }
}
