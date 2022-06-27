package com.example.MP2.dto;

import com.example.MP2.entity.Adopt;
import lombok.*;

import java.sql.Blob;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdoptDTO {
    public long ano;
    public String regionID;
    public String userID;
    private String title;
    private String contents;
    private Blob image;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    public AdoptDTO(final Adopt entity) {
        this.ano = entity.getAno();
        this.regionID = entity.getRegionID();
        this.userID = entity.getUserID();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
        this.image = entity.getImage();
    }

    public static Adopt toEntity(final AdoptDTO dto) {
        return Adopt.builder()
                .ano(dto.getAno())
                .userID(dto.getUserID())
                .regionID(dto.getRegionID())
                .title(dto.getTitle())
                .contents(dto.getContents())
                .image(dto.getImage())
                .build();
    }
}
