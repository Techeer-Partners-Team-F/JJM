package com.example.demo.coment.service;

import com.example.demo.coment.dto.ComentDto;
import com.example.demo.coment.entity.Coment;
import com.example.demo.coment.repository.ComentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComentService {

    private final ComentRepository comentRepository;

    @Transactional
    public Long createComent(ComentDto comentDto) {
        return comentRepository.save(comentDto.toEntity()).getId();
    }

    @Transactional
    public ComentDto getComent(Long comentId) {
        Coment coment = comentRepository.findById(comentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글을 찾을 수 없습니다."));

        return ComentDto.fromEntity(coment);
    }

    @Transactional
    public ComentDto updateComent(Long comentId, ComentDto comentDto) {
        Coment coment = comentRepository.findById(comentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글을 찾을 수 없습니다."));

        coment.update(comentDto);
        return comentDto.fromEntity(coment);
    }


    @Transactional
    public void deletedComent(Long comentId) {
        Coment coment = comentRepository.findById(comentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글을 찾을 수 없습니다."));

        comentRepository.delete(coment);
    }
}
