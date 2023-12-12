package com.smhrd.bridge.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "userinfo")
@Getter
@Setter
@NoArgsConstructor
public class UserInfo {
	@Id
	@Column(name = "userId", length = 20, nullable = false)
	private String userId;
	
	@Column(name = "userPw", length = 50, nullable = false)
	private String userPw;

	@Column(name = "userName", length = 20, nullable = false)
	private String userName;

	@Column(name = "userNick", length = 20, nullable = false)
	private String userNick;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "userBirthday", nullable = false)
	private LocalDate userBirthday;
	
	@CreationTimestamp // 실제 시간 읽기
	@Column(name = "joinDate", nullable = false)
	private LocalDate joinDate;

	@Column(name = "userAddress", nullable = false)
	private String userAddress;
}
