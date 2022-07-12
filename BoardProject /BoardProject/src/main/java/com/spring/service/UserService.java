package com.spring.service;

import com.spring.dto.UserDTO;

public interface UserService {
	public void insertUser(UserDTO userDTO);

	UserDTO getUserByUserEmail(String userEmail);

}