package com.spring.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.dto.CommentDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_no")
	private Long commentNo;

	@Column(length = 255, name = "comment_content")
	private String commentContent;

	@Column(length = 255)
	private String commenter;

	@CreatedDate
	@Column(name = "registerd_date")
	private LocalDate regiDate;

	@LastModifiedDate
	@Column(name = "modified_date")
	private LocalDate modiDate;

	@ManyToOne
	@JoinColumn(name = "board_no")
	private Board board;



	// toDTO

	public CommentDTO toDTO(Comment commentEntity) {
		CommentDTO commentDTO = CommentDTO.builder().commentNo(commentEntity.getCommentNo())
				.commentContent(commentEntity.getCommentContent())
				.commenter(commentEntity.getCommenter()).board(commentEntity.getBoard())
				.regiDate(commentEntity.getRegiDate()).modiDate(commentEntity.getModiDate()).build();
		return commentDTO;
		
	}

}
