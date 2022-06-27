package com.example.MP2.repository;

import com.example.MP2.entity.Adopt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptRepository extends JpaRepository<Adopt, Long> {
}
