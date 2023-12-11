package com.smhrd.bridge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usersong")
public class UserSong {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long user_song_idx;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserInfo user_id;
	
	@ManyToOne
	@JoinColumn(name = "song_num")
	private SongList song_num;
	
	@Column(name = "user_name", nullable = false)
	private boolean user_name;
	
	@Column(name = "song_file", nullable = false)
	private String song_file;
}
