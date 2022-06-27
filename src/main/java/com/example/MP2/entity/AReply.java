package com.example.MP2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AReplyTbl"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "phone_number")}*/)
public class AReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rano;

    @Column(name = "Ano", nullable = false, unique = true)
    public long ano;

    @Column(name = "AReply", length = 10000, nullable = false)
    private String areply;

    @Column(name = "UserID", length = 20, nullable = false)
    public String userID;
}
