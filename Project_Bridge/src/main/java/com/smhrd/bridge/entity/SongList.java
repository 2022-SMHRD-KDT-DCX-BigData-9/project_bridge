package com.smhrd.bridge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "songlist")
public class SongList {
	@Id
	@Column(name = "song_num")
	private int song_num;
	
	@Column(name = "song_name", length = 100, nullable = false)
	private String song_name;
	
	@Column(name = "singer", length = 30, nullable = false)
	private String singer;
}