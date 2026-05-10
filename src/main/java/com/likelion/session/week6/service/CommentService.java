package com.likelion.session.week6.service;

import com.likelion.session.week6.entity.Board;
import com.likelion.session.week6.entity.Comment;
import com.likelion.session.week6.repository.BoardRepository;
import com.likelion.session.week6.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    // 댓글 생성
    public Comment createComment(Long boardId, String content, String writer) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

        Comment comment = Comment.builder()
                .content(content)
                .writer(writer)
                .board(board)
                .build();

        return commentRepository.save(comment);
    }

    // 특정 게시글의 댓글 전체 조회
    public List<Comment> getComments(Long boardId) {
        return commentRepository.findByBoardBoardId(boardId);
    }

    // 댓글 수정
    public Comment updateComment(Long commentId, String content) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다."));

        Comment updatedComment = Comment.builder()
                .commentId(comment.getCommentId())
                .content(content)
                .writer(comment.getWriter())
                .board(comment.getBoard())
                .build();

        return commentRepository.save(updatedComment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}