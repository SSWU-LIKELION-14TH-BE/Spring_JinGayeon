package com.likelion.session.week6.repository;

import com.likelion.session.week6.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByBoardBoardId(Long boardId);
}