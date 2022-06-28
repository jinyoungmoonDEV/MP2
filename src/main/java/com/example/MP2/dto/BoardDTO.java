package com.example.MP2.dto;

import com.example.MP2.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {

	public Long bno;
	public String rcode;
	public String userid;
	private String title;
	private String contents;

	private LocalDateTime regdate;
	private LocalDateTime moddate;
}

