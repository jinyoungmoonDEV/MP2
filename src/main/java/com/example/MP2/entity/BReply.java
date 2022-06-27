package com.example.MP2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "breplyTbl")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "breplyTbl"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "phone_number")}*/)
public class BReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rbno;

    @Column(name = "Bno", nullable = false, unique = true)
    public long bno;

    @Column(name = "BReply", length = 10, nullable = false)
    private String breply;

    @Column(name = "userID", length = 20, nullable = false)
    public String userID;
}
