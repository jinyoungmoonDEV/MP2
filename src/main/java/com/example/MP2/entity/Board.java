package com.example.MP2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "boardTbl")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "boardTbl"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "phone_number")}*/)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bno;

    @Column(name = "regionID", length = 10, nullable = false)
    public String regionID;

    @Column(name = "userID", length = 20, nullable = false)
    public String userID;

    @Column(name = "title", length = 30, nullable = false)
    private String title;

    @Column(name = "contents",length = 10000, nullable = false)
    private String contents;

    @Column(name = "viewers", length = 10)
    private long viewers;

    @Column(name = "replyCnt", length = 1000)
    private long replyCnt;

    @OneToMany
    @JoinColumn(name = "bno")
    private List<BReply> bnoReplyEntitySet;
}
