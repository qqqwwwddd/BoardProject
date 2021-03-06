package com.spring.api;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.BoardDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.model.Board;
import com.spring.service.BoardServiceImpl;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:3001" })
@RestController
public class BoardRestController {

	@Autowired
	BoardServiceImpl boardService;

	// 모든 Board (페이지)
	@GetMapping(value = "/boardList")
	public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO pageDTO) {
		System.out.println(pageDTO);
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(pageDTO.getPage()).size(10).build();
		PageResultDTO<BoardDTO, Board> pageResultDTO = boardService.getList(pageRequestDTO);
		return pageResultDTO;
	}

	// boardNO 로 Board 검색
	@GetMapping(value = "/board/{boardNo}")
	public BoardDTO getBoardById(@PathVariable Long boardNo) {
		System.out.println(boardNo);
		return boardService.getBoardById(boardNo);
	}

	// Board 추가
	@PostMapping(value = "/board", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertBoard(@RequestBody BoardDTO boardDTO) {
		System.out.println(boardDTO);
		boardService.insertBoard(boardDTO);

	}

	// Board 수정
	@PutMapping(value = "/board/{boardNo}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public void updateBoard(@PathVariable Long boardNo, @RequestBody BoardDTO boardDTO) {
		System.out.println(boardNo);
		boardService.updateBoardByBoardNo(boardNo, boardDTO);
	}

	// Board 삭제
	@DeleteMapping(value = "/board/{boardNo}")
	public void deleteBoard(@PathVariable Long boardNo) {
		boardService.deleteBoardByBoardNo(boardNo);

	}

}
