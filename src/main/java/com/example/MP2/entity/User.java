package com.example.MP2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UserTbl"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "phone_number")}*/)
public class User {
    @Id
    @Column(name = "phoneNumber", length = 11)
    private String phoneNumber;

    @Column(name = "passWord", length = 100, nullable = false)
    private String passWord;

    @Column(name = "userID", length = 10, nullable = false)
    public String userID;

    @OneToOne
    @JoinColumn(name = "userID", insertable=false, updatable=false)
    private Address address;
}
