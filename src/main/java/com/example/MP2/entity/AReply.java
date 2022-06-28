package com.example.MP2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "areply_tbl")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "areply_tbl"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "phone_number")}*/)
public class AReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rano;


    @Column(name = "areply", length = 10000, nullable = false)
    private String areply;

    @ManyToOne
    @JoinColumn(name = "ano")
    private Adopt adopt;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;
}
