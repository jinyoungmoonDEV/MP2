package com.example.MP2.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;
import java.util.Set;


@Entity(name = "board_tbl")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "board_tbl"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "phone_number")}*/)
@ToString
@Getter
public class Board extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bno;

    @Column(name = "title", length = 30, nullable = false)
    private String title;

    @Column(name = "contents",length = 10000, nullable = false)
    private String contents;

    @Column
    private Blob image;

    @ManyToOne
    @JoinColumn(name = "rcode")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User userid;

    public void changeTitle(String title){
        this.title = title;
    }

    public void changeContent(String content){
        this.contents = content;
    }
}
