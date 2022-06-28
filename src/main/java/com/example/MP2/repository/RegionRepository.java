package com.example.MP2.repository;

import com.example.MP2.dto.RegionDTO;
import com.example.MP2.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RegionRepository extends JpaRepository<Region ,String> {

    @Query(value = "insert into region_tbl(rcode,address) values (1168010100,\"역삼동\"),(1168010300,\"개포동\"),(1168010400,\"청담동\"),(1168010500,\"삼성동\"),(1168010600,\"대치동\"),(1168010700,\"신사동\"),(1168010800,\"논현동\"),(1168011000,\"압구정동\"),(1168011100,\"세곡동\"),(1168011200,\"자곡동\"),(1168011300,\"율현동\"),(1168011400,\"일원동\"),(1168011500,\"수서동\"),(1168011800,\"도곡동\");", nativeQuery = true)
    public List<RegionDTO> insertRegion();
}
