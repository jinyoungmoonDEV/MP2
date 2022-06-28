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
    public String rcode;
    public String userid;
    private String title;
    private String contents;
    private Blob image;
    private LocalDateTime regdate;
    private LocalDateTime moddate;
}
