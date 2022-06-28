package com.example.MP2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "adopt_tbl")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adopt_tbl"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "phone_number")}*/)
public class Adopt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long ano;

    @Column(name = "title", length = 30, nullable = false)
    private String title;

    @Column(name = "contents",length = 10000, nullable = false)
    private String contents;

    @Column(name = "image",length = 10000)
    private Blob image;

    @ManyToOne
    @JoinColumn(name = "rcode")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;
}
