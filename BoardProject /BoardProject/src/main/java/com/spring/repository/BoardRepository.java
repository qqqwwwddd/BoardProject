package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
	public List<Board> findAll();

	// Board 검색
	public Board getBoardByBoardNo(Long boardNo);


}
