package com.example.demo.coment.controller;

import com.example.demo.coment.dto.ComentDto;
import com.example.demo.coment.service.ComentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ComentController {

    private final ComentService comentService;

    @PostMapping("/coment")
    public ResponseEntity<?> createComent(@RequestBody  ComentDto comentDto) {
        try {
            comentService.createComent(comentDto);
            return ResponseEntity.ok("댓글 작성 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("댓글 작성에 실패하였습니다: ");
        }
    }

    @GetMapping("/coment/{id}")
    public ResponseEntity<?> getComent(@PathVariable Long id) {
        try {
            ComentDto comentDto = comentService.getComent(id);
            return ResponseEntity.ok(comentDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("댓글 조회에 실패하였습니다: ");
        }
    }

    @PutMapping("/coment/{id}")
    public ResponseEntity<?> updateComent(@PathVariable Long id, @RequestBody ComentDto comentDto) {
        try {
            ComentDto responsecomentDto = comentService.updateComent(id, comentDto);
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
