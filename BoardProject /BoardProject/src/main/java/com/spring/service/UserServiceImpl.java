package com.spring.service;


import org.springframework.stereotype.Service;

import com.spring.dto.UserDTO;
import com.spring.model.User;
import com.spring.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public void insertUser(UserDTO userDTO) {
		if (userDTO != null) {
			User userEntity = userDTO.toEntity(userDTO);
			userRepository.save(userEntity);
		}
	}


	@Override
	public UserDTO getUserByUserEmail(String userEmail) {
		User user = userRepository.getUserByUserEmail(userEmail);
		return user.toDTO(user);
	}

}
