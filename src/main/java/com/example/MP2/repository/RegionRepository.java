package com.example.MP2.repository;

import com.example.MP2.dto.RegionDTO;
import com.example.MP2.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region ,String> {

    @Query(value = "insert into region_tbl(regionid) values (1168010100),(1168010300),(1168010400),(1168010500),(1168010600),(1168010700),(1168010800),(1168011000),(1168011100),(1168011200),(1168011300),(1168011400),(1168011500),(1168011800);", nativeQuery = true)
    public List<RegionDTO> insertRegion();
}
