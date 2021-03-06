package com.spring.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.spring.model.Board;
import com.spring.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

	private String userEmail;

	private String userName;

	private String userPwd;

	private LocalDateTime regiDate;

	private LocalDateTime modiDate;

	List<Board> boards = new ArrayList<Board>();

	// toEntity
	public User toEntity(UserDTO userDTO) {
		User userEntity = User.builder().userEmail(userDTO.getUserEmail()).userName(userDTO.getUserName())
				.userPwd(userDTO.getUserPwd()).regiDate(userDTO.getRegiDate()).modiDate(userDTO.getModiDate()).build();

		return userEntity;

	}

}
