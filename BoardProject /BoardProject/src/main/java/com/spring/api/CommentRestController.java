package com.spring.api;

import java.util.List;

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

import com.spring.dto.CommentDTO;
import com.spring.service.CommentServiceImpl;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:3001" })
@RestController
public class CommentRestController {

	@Autowired
	private CommentServiceImpl commentService;

	// 모든 댓글
	@GetMapping(value = "/comment/{boardNo}")
	public List<CommentDTO> findAllbyBoardBoardNo(@PathVariable Long boardNo) {
//
		List<CommentDTO> comments = commentService.getList(boardNo);
		return comments;
	}

	// 댓글 추가
	@PostMapping(value = "/comment", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertComment(@RequestBody CommentDTO commentDTO) {
		System.out.println(commentDTO);
		commentService.insertComment(commentDTO);
	}

	// 댓글 수정
	@PutMapping(value = "/comment/{commentNo}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public void updateComment(@PathVariable Long commentNo, @RequestBody CommentDTO commentDTO) {
		commentService.updateComment(commentNo, commentDTO);

	}

	// 댓글 삭제
	@DeleteMapping(value = "/comment/{commentNo}")
	public void deleteComment(@PathVariable Long commentNo) {
		commentService.deleteComment(commentNo);
	}

}
