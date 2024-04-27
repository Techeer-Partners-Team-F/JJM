package com.example.demo.board.controller;

import com.example.demo.board.dto.BoardRequestDto;
import com.example.demo.board.dto.BoardResponseDto;
import com.example.demo.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<?> createBoard(@RequestBody BoardRequestDto boardRequestDto) {
        try {
            Long petBoardId = boardService.createBoard(boardRequestDto);
            return ResponseEntity.ok().body("게시물 작성에 성공하였습니다.");
        } catch (Exception e) {
            // 로그에 에러 메시지를 남기고, 에러 메시지를 클라이언트에게 반환
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("게시물 작성에 실패하였습니다: " + e.getMessage());
        }
    }

    @GetMapping("/board/{id}")
    public ResponseEntity<?> getBoard(@PathVariable Long id) {
        try {
            BoardResponseDto boardResponseDto = boardService.getBoard(id);
            return ResponseEntity.ok().body(boardResponseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("게시물 작성에 실패하였습니다.");
        }
    }

    @PutMapping("/board/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto) {
        try {
            BoardResponseDto boardResponseDto = boardService.updateBoard(id, boardRequestDto);
            return ResponseEntity.ok(boardResponseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("게시글 조회에 실패하였습니다.");
        }
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<?> deletedBoard(@PathVariable Long id) {
        try {
            boardService.deletedBoard(id);
            return ResponseEntity.ok().body("게시물 삭제에 성공하였습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시물 삭제에 실패하였습니다.");
        }
    }
}
