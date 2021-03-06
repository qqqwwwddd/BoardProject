package com.spring.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.spring.model.Board;
import com.spring.model.Comment;
import com.spring.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {

	private Long boardNo;

	private String boardTitle;

	private String boardContent;

	private LocalDate regiDate;

	private LocalDate modiDate;

	private User user;

	List<Comment> comments = new ArrayList<Comment>();

	// toEntity
	public Board toEntity(BoardDTO boardDTO) {
		Board boardEntity = Board.builder().boardNo(boardDTO.getBoardNo()).boardTitle(boardDTO.getBoardTitle())
				.boardContent(boardDTO.getBoardContent()).regiDate(boardDTO.getRegiDate())
				.comments(boardDTO.getComments())
				.modiDate(boardDTO.getModiDate()).user(boardDTO.getUser()).build();

		return boardEntity;
	}

}
