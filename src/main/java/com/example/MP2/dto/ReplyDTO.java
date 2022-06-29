package com.example.MP2.dto;

import com.example.MP2.entity.User;
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
    private long bno;
    private String reply;
    private User userid;
    private LocalDateTime regdate;
    private LocalDateTime moddate;

}
