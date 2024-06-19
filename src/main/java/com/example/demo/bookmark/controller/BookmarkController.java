package com.example.demo.bookmark.controller;


import com.example.demo.board.dto.BoardRequestDto;
import com.example.demo.bookmark.dto.BookmarkDto;
import com.example.demo.bookmark.dto.DeleteBookmarkRequest;
import com.example.demo.bookmark.dto.RequestDto;
import com.example.demo.bookmark.service.BookmarkService;
import jakarta.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookmarkController {

    private static final Logger log = LoggerFactory.getLogger(BookmarkController.class);
    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @PostMapping("/bookmarks")
    public ResponseEntity<?> createBookmark(@RequestBody RequestDto RequestDto) {
        try {
            Long bookmarkId = bookmarkService.createBookmark(RequestDto);
            return ResponseEntity.ok().body("북마크 생성에 성공하였습니다.");
        } catch (Exception e) {
            // 로그에 에러 메시지를 남기고, 에러 메시지를 클라이언트에게 반환
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("북마크 생성에 실패하였습니다: " + e.getMessage());
        }
    }

    @GetMapping("/bookmarks/{uid}")
    public ResponseEntity<?> getBookmarks(@PathVariable Long uid, Pageable pageable) {
        try {
            Page<BookmarkDto> bookmarkDto = bookmarkService.getUserBookmarks(pageable, uid);
            return ResponseEntity.ok().body(bookmarkDto.getContent());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("북마크 조회에 실패하였습니다.");
        }
    }
    @DeleteMapping("/bookmarks/{uid}")
    public ResponseEntity<?> deleteBookmark(@PathVariable Long uid, @RequestBody DeleteBookmarkRequest request) {
        try {
            bookmarkService.deleteBookmark(uid, request.getBookmarkId());
            return ResponseEntity.ok().body("북마크 삭제에 성공하였습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("북마크 삭제에 실패하였습니다.");
        }
    }
}

