package com.example.MP2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "board_tbl")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "board_tbl"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "phone_number")}*/)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bno;

    @Column(name = "title", length = 30, nullable = false)
    private String title;

    @Column(name = "contents",length = 10000, nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "rcode")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;
}
