package com.smhrd.bridge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "userinfo")
public class UserInfo {
	@Id
	@Column(name = "user_id", length = 20, nullable = false)
	private String user_id;
	
	@Column(name = "user_pw", length = 50, nullable = false)
	private String user_pw;

	@Column(name = "user_name", length = 20, nullable = false)
	private String user_name;

	@Column(name = "user_nick", length = 20, nullable = false)
	private String user_nick;
	
	@Column(name = "user_birthday", nullable = false)
	private Date user_birthday;
	
	@CreationTimestamp // 실제 시간 읽기
	@Column(name = "join_birthday", nullable = false)
	private Date join_birthday;

	@Column(name = "user_address", nullable = false)
	private String user_address;
}
