package com.spring.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.dto.UserDTO;

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
@ToString(exclude = { "boards" })
public class User {

	@Id
	@Column(length = 255, name = "user_email")
	private String userEmail;

	@Column(length = 255, name = "user_name")
	private String userName;

	@Column(length = 255, name = "user_password")
	private String userPwd;

	@CreatedDate
	@Column(name = "registered_date")
	private LocalDateTime regiDate;

	@LastModifiedDate
	@Column(name = "modified_date")
	private LocalDateTime modiDate;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonIgnore
	List<Board> boards = new ArrayList<Board>();



	// toDTO
	public UserDTO toDTO(User userEntity) {
		UserDTO userDTO = UserDTO.builder().userEmail(userEntity.getUserEmail()).userName(userEntity.getUserName())
				.userPwd(userEntity.getUserPwd()).regiDate(userEntity.getRegiDate()).modiDate(userEntity.getModiDate())
				.build();
		return userDTO;
	}

}
