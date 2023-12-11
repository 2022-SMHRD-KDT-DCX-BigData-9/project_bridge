package com.smhrd.bridge.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userlikelist")

public class UserLikeList {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idx;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserInfo user_id;
	
	@ManyToOne
	@JoinColumn(name = "song_num")
	private SongList song_num;
	
}
