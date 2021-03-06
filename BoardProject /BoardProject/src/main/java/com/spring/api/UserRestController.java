package com.spring.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.UserDTO;
import com.spring.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UserRestController {

	private final UserServiceImpl userService;

//	// 모든 User (페이징)
//		@GetMapping(value = "/userList")
//		public PageResultDTO<UserDTO, User> getList(PageRequestDTO pageDTO) {
//			System.out.println(pageDTO);
//			PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(pageDTO.getPage()).size(10).build();
//			PageResultDTO<UserDTO, User> pageResultDTO = userService.getList(pageRequestDTO);
//			return pageResultDTO;
//		}

	// Email로 User 검색
	@GetMapping(value = "/user/{userEmail}")
	public UserDTO getUserByUserEmail(@PathVariable String userEmail) {
		System.out.println(userEmail);
		UserDTO user = userService.getUserByUserEmail(userEmail);
		System.out.println(user);
		return user;
	}

	// User 등록
	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertUser(@RequestBody UserDTO userDTO) {
		userService.insertUser(userDTO);
	}

}
