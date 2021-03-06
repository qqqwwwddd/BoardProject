package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.CommentDTO;
import com.spring.model.Comment;
import com.spring.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	// 전체 댓글
	@Override
	public List<CommentDTO> getList(Long boardNo) {
		List<Comment> commentList = commentRepository.findCommentByBoardBoardNo(boardNo);
		List<CommentDTO> commentDTO = new ArrayList<CommentDTO>();
		for (Comment commentEntity : commentList) {
			commentDTO.add(commentEntity.toDTO(commentEntity));
		}

		return commentDTO;
	}


	// 댓글 추가
	@Override
	public void insertComment(CommentDTO commentDTO) {
			commentRepository.save(commentDTO.toEntity(commentDTO));

	}

	// 댓글 수정
	@Override
	public void updateComment(Long commentNo, CommentDTO newcommentDTO) {
		Comment commentFind = commentRepository.findCommentByCommentNo(commentNo);

		if (commentFind != null) {
			newcommentDTO.setCommentNo(commentNo);
			newcommentDTO.setCommenter(commentFind.getCommenter());
			newcommentDTO.setRegiDate(commentFind.getRegiDate());
			commentRepository.save(newcommentDTO.toEntity(newcommentDTO));
		}
	}

	// 댓글 삭제
	@Override
	public void deleteComment(Long commentNo) {
		commentRepository.deleteById(commentNo);
	}





}
