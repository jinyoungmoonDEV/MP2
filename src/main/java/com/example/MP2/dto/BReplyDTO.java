package com.example.MP2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BReplyDTO {

    private long rbno;
    public long bno;
    private String breply;
    public String userID;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

}
