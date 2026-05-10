package com.likelion.session.week6.controller;

import com.likelion.session.week6.entity.Comment;
import com.likelion.session.week6.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards/{boardId}/comments")
public class CommentController {

    private final CommentService commentService;

    // 댓글 생성
    @PostMapping
    public Comment createComment(
            @PathVariable Long boardId,
            @RequestParam String content,
            @RequestParam String writer
    ) {
        return commentService.createComment(boardId, content, writer);
    }

    // 댓글 조회
    @GetMapping
    public List<Comment> getComments(@PathVariable Long boardId) {
        return commentService.getComments(boardId);
    }

    // 댓글 수정
    @PutMapping("/{commentId}")
    public Comment updateComment(
            @PathVariable Long commentId,
            @RequestParam String content
    ) {
        return commentService.updateComment(commentId, content);
    }

    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    public String deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return "댓글 삭제 완료";
    }
}