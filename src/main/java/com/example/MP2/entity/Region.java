package com.example.MP2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "regionTbl")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "regionTbl")
public class Region {
    @Id
    public String regionID;

    @OneToOne
    @JoinColumn(name = "regionID")
    private Address address;
}
