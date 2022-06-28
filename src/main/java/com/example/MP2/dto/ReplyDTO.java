package com.example.MP2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReplyDTO {

    private long rno;
    public long bno;
    private String reply;
    public String userid;
    private LocalDateTime regdate;
    private LocalDateTime moddate;

}
