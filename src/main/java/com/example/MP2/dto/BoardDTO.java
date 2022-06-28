package com.example.MP2.dto;

import com.example.MP2.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardDTO {

	public Long bno;
	public String rcode;
	public String userid;
	private String title;
	private String contents;
	private Blob image;
	private LocalDateTime regdate;
	private LocalDateTime moddate;
}

