package com.smhrd.bridge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "songlist")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SongList {
	@Id
	@Column(name = "songNum")
	private int songNum;
	
	@Column(name = "songName", length = 100, nullable = false)
	private String songName;
	
	@Column(name = "singer", length = 30, nullable = false)
	private String singer;
}