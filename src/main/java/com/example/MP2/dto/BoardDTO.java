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
	public String regionID;
	public String userID;
	private String title;
	private String contents;
	private Long viewers;
	private Long replycCnt;
	private LocalDateTime regDate;
	private LocalDateTime modDate;

	public BoardDTO(final Board entity) {
		this.bno = entity.getBno();
		this.regionID = entity.getRegionID();
		this.userID = entity.getUserID();
		this.title= entity.getTitle();
		this.viewers = entity.getViewers();
		this.replycCnt = entity.getReplyCnt();
	}

	public static Board toEntity(final BoardDTO dto) {
		return Board.builder()
				.bno(dto.getBno())
				.userID(dto.getUserID())
				.regionID(dto.getRegionID())
				.title(dto.getTitle())
				.viewers(dto.getViewers())
				.replyCnt(dto.getReplycCnt())
				.build();
	}
}

