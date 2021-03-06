package com.spring.service;

import java.util.List;

import com.spring.dto.CommentDTO;

public interface CommentService {

	public List<CommentDTO> getList(Long boardNo);

	public void insertComment(CommentDTO commentDTO);

	public void deleteComment(Long commentNo);

	public void updateComment(Long commentNo, CommentDTO commentDTO);

}
