package com.example.MP2.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity(name = "breply_tbl")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "bno")
@Table(name = "breply_tbl"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "phone_number")}*/)
public class Reply extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rno;

    @Column(name = "reply", length = 10, nullable = false)
    private String reply;

/*    @Column(name = "userid", length = 10, nullable = false)
    private String userid;*/

    @ManyToOne
    @JoinColumn(name = "bno")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User userid;

}
