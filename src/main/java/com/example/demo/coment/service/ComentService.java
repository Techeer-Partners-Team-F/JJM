package com.example.demo.coment.service;

import com.example.demo.coment.dto.CommentDto;
import com.example.demo.coment.entity.Comment;
import com.example.demo.coment.repository.ComentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComentService {

    private final ComentRepository comentRepository;

    @Transactional
    public Long createComent(CommentDto commentDto) {
        return comentRepository.save(commentDto.toEntity()).getId();
    }

    @Transactional
    public CommentDto getComent(Long comentId) {
        Comment comment = comentRepository.findById(comentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글을 찾을 수 없습니다."));

        return CommentDto.fromEntity(comment);
    }

    @Transactional
    public Page<CommentDto> getComents(Pageable pageable) {
        return comentRepository.findAll(pageable)
                .map(CommentDto::fromEntity);
    }

    @Transactional
    public CommentDto updateComent(Long comentId, CommentDto commentDto) {
        Comment comment = comentRepository.findById(comentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글을 찾을 수 없습니다."));

        comment.update(commentDto);
        return commentDto.fromEntity(comment);
    }


    @Transactional
    public void deletedComent(Long comentId) {
        Comment comment = comentRepository.findById(comentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글을 찾을 수 없습니다."));

        comentRepository.delete(comment);
    }
}
