package com.spring.service;

import java.util.List;

import com.spring.dto.BoardDTO;

public interface BoardService {

	// 모든 Board
	public List<BoardDTO> getAllBoard();

	// Board 검색
	public BoardDTO getBoardById(Long boardNo);

	// Board 추가
	public void insertBoard(BoardDTO boardDTO);

	// Board 수정
	public void updateBoardByBoardNo(Long boardNo, BoardDTO boardDTO);

	// Board 삭제
	public void deleteBoardByBoardNo(Long boardNo);

}
