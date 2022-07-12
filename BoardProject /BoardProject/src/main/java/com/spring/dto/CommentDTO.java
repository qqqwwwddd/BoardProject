package com.spring.dto;

import java.time.LocalDateTime;

import com.spring.model.Board;
import com.spring.model.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {

	private Long commentNo;

	private String commentContent;

	private String commenter;

	private LocalDateTime regiDate;

	private LocalDateTime modiDate;

	private Board board;

	// toEntity
	public Comment toEntity(CommentDTO commentDTO) {
		Comment commentEntity = Comment.builder().commentNo(commentDTO.getCommentNo())
				.commentContent(commentDTO.getCommentContent()).commenter(commentDTO.getCommenter())
				.board(commentDTO.getBoard())
				.regiDate(commentDTO.getRegiDate()).modiDate(commentDTO.getModiDate()).build();

		return commentEntity;

	}

}
