package com.example.MP2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "addressTbl")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addressTbl"/*, uniqueConstraints = {@UniqueConstraint(columnNames = "phone_number")}*/)
public class Address {
    @Id
    public String AddressID;

    @Column(name = "regionID", length = 10, nullable = false)
    public String regionID;

    @Column(name = "userID", length = 10, nullable = false)
    public String userID;

    @OneToOne
    @JoinColumn(name = "userID", insertable=false, updatable=false)
    private User user;

    @OneToOne
    @JoinColumn(name = "regionID", insertable=false, updatable=false)
    private Region region;
}
