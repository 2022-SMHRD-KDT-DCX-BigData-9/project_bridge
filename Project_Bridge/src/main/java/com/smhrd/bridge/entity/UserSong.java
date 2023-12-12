package com.smhrd.bridge.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usersong")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSong {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userSongIdx;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserInfo userId;

	@Column(name = "noiseCancel", nullable = false)
	private boolean noiseCancel;
	
	@Column(name = "songFile", nullable = false)
	private String songFile;
		
	@Column(name = "userSongName", length = 100, nullable = false)
	private String userSongName;
	
	@Column(name = "userSinger", length = 30, nullable = false)
	private String userSinger;
	
	@CreationTimestamp
	@Column(name = "createdAt", nullable = false)
	private LocalDate createdAt;
	

	
	
}
