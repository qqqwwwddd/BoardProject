package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	public List<Comment> findCommentByBoardBoardNo(Long boardNo);

	public Comment findCommentByCommentNo(Long commentNo);

}
