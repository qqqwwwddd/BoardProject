package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.dto.BoardDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.model.Board;
import com.spring.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;

	// Pagination
	public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("boardNo").ascending());

		Page<Board> result = boardRepository.findAll(pageable);

		// entity -> dto
		Function<Board, BoardDTO> function = (deptEntity -> deptEntity.toDTO(deptEntity));

		return new PageResultDTO<BoardDTO, Board>(result, function);
	}

	// 모든 Board
	@Override
	public List<BoardDTO> getAllBoard() {

		List<BoardDTO> boardDTO = new ArrayList<BoardDTO>();
		for (Board boardEntity : boardRepository.findAll()) {
			boardDTO.add(boardEntity.toDTO(boardEntity));
		}

		return boardDTO;
	}

	// Board 검색
	@Override
	public BoardDTO getBoardById(Long boardNo) {
		Board boardEntity = boardRepository.getBoardByBoardNo(boardNo);
		if (boardEntity != null) {
			return boardEntity.toDTO(boardEntity);
		} else {
			return null;
		}
	}

	// Board 추가
	@Override
	public void insertBoard(BoardDTO boardDTO) {

//		UserServiceImpl.getUserByUserEmail(boardDTO.getUserEmail());
		Board board = boardDTO.toEntity(boardDTO);
		System.out.println(board);
		boardRepository.save(boardDTO.toEntity(boardDTO));
	}

	// Board 수정
	@Override
	public void updateBoardByBoardNo(Long boardNo, BoardDTO newBoardDTO) {
		System.out.println(boardNo);
		Board boardFind = boardRepository.getBoardByBoardNo(boardNo);

		if (boardFind != null) {
			newBoardDTO.setBoardNo(boardNo);
			newBoardDTO.setRegiDate(boardFind.getRegiDate());
			boardRepository.save(newBoardDTO.toEntity(newBoardDTO));
		}

	}

	// Board 삭제
	@Override
	public void deleteBoardByBoardNo(Long boardNo) {
		boardRepository.deleteById(boardNo);

	}



}
