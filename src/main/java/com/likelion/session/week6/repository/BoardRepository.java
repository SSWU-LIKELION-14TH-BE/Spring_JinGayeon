package com.likelion.session.week6.repository;

import com.likelion.session.week6.entity.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BoardRepository extends CrudRepository <Board, Long> {

    Optional<Board> findByBoardId(Long boardId);

    void deleteByBoardId(Long boardId);
}
