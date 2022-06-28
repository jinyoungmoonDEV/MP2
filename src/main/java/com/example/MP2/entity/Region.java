package com.example.MP2.entity;

import com.example.MP2.dto.RegionDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

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
    private String rcode;

    @Column(name = "address")
    private String address;
}
