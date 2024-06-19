package com.example.demo.bookmark.repository;

import com.example.demo.bookmark.entity.Bookmark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    Page<Bookmark> findBookmarksByUserId(Pageable pageable, Long userId);
    Optional<Bookmark> findByIdAndUserId(Long bookmarkId, Long userId);
}
