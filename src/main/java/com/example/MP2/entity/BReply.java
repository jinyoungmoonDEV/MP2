package com.example.MP2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "breply_tbl")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "breply_tbl"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "phone_number")}*/)
public class BReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rbno;

    @Column(name = "breply", length = 10, nullable = false)
    private String breply;

    @ManyToOne
    @JoinColumn(name = "bno")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

}
