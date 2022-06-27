package com.example.MP2.repository;

import com.example.MP2.entity.AReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AReplyRepository extends JpaRepository<AReply, Long> {
}
