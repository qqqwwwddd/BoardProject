package com.spring.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.dto.BoardDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = { "comments" })
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_no")
	private Long boardNo;

	@Column(length = 255, name = "board_title")
	private String boardTitle;

	@Column(length = 255, name = "board_content")
	private String boardContent;

	@CreatedDate
	@Column(name = "registered_date")
	private LocalDate regiDate;

	@LastModifiedDate
	@Column(name = "modified_date")
	private LocalDate modiDate;

	@ManyToOne
	@JoinColumn(name = "user_email")
	private User user;

	
	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
	@JsonIgnore
	List<Comment> comments = new ArrayList<Comment>();



	// toDTO
	public BoardDTO toDTO(Board boardEntity) {
		BoardDTO boardDTO = BoardDTO.builder().boardNo(boardEntity.getBoardNo()).boardTitle(boardEntity.getBoardTitle())
				.boardContent(boardEntity.getBoardContent()).regiDate(boardEntity.getRegiDate())
				.modiDate(boardEntity.getModiDate()).comments(boardEntity.getComments()).user(boardEntity.getUser())
				.build();

		return boardDTO;
	}

}
