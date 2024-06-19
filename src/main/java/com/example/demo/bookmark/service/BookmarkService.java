package com.example.demo.bookmark.service;


import com.example.demo.board.entity.Board;
import com.example.demo.bookmark.dto.BookmarkDto;
import com.example.demo.bookmark.dto.RequestDto;
import com.example.demo.bookmark.entity.Bookmark;
import com.example.demo.bookmark.repository.BookmarkRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    @Transactional
    public Long createBookmark(RequestDto requestDto) {
        Board board = Board.builder()
                .id(requestDto.getBoard().getId())
                .title(requestDto.getBoard().getTitle())
                .content(requestDto.getBoard().getContent())
                .build();

        Bookmark bookmark = Bookmark.builder()
                .userId(requestDto.getUserId())
                .board(board)
                .build();

        bookmarkRepository.save(bookmark);

        return bookmark.getId();
    }

    @Transactional
    public Page<BookmarkDto> getUserBookmarks(Pageable pageable, Long userId) throws IllegalAccessException {
        if (!bookmarkRepository.existsById(userId)) {
            throw new IllegalAccessException("해당 유저의 북마크가 존재하지 않습니다.");
        }
        Page<Bookmark> bookmarkPage = bookmarkRepository.findBookmarksByUserId(pageable, userId);
        return bookmarkPage.map(BookmarkDto::fromEntity);
    }

    @Transactional
    public void deleteBookmark(Long userId, Long bookmarkId) {
        Optional<Bookmark> optionalBookmark = bookmarkRepository.findByIdAndUserId(bookmarkId, userId);

        if (optionalBookmark.isPresent()) {
            bookmarkRepository.deleteById(bookmarkId);
        } else {
            throw new IllegalArgumentException("Bookmark not found or does not belong to the user");
        }
    }
}
