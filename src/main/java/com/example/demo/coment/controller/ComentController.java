package com.example.demo.coment.controller;

import com.example.demo.coment.dto.CommentDto;
import com.example.demo.coment.service.ComentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class ComentController {

    private final ComentService comentService;

    @PostMapping("/comment")
    public ResponseEntity<?> createComent(@RequestBody CommentDto commentDto) {
        try {
            comentService.createComent(commentDto);
            return ResponseEntity.ok("댓글 작성 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("댓글 작성에 실패하였습니다: ");
        }
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<?> getComent(@PathVariable Long id) {
        try {
            CommentDto commentDto = comentService.getComent(id);
            return ResponseEntity.ok(commentDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("댓글 조회에 실패하였습니다: ");
        }
    }

    @GetMapping("/comment")
    public ResponseEntity<?> getComents(Pageable pageable) {
        try {
            Page<CommentDto> commentPage = comentService.getComents(pageable);
            return ResponseEntity.ok(commentPage.getContent());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("댓글 조회에 실패하였습니다: ");
        }
    }

    @PutMapping("/comment/{id}")
    public ResponseEntity<?> updateComent(@PathVariable Long id, @RequestBody CommentDto commentDto) {
        try {
            CommentDto responsecomentDto = comentService.updateComent(id, commentDto);
            return ResponseEntity.ok(responsecomentDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("댓글 수정에 실패하였습니다: ");
        }
    }

    @DeleteMapping("/coment/{id}")
    public ResponseEntity<?> deletedComent(@PathVariable Long id) {
        try {
            comentService.deletedComent(id);
            return ResponseEntity.ok("댓글 삭제 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("댓글 삭제에 실패하였습니다: ");
        }
    }
}
