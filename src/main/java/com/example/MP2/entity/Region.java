package com.example.MP2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "region_tbl")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "region_tbl")
public class Region {
    @Id
    private String regionid;

    @Column(name = "address")
    private String address;

}
