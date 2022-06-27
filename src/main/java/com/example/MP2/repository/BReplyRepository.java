package com.example.MP2.repository;

import com.example.MP2.entity.BReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BReplyRepository extends JpaRepository<BReply, Long> {
}
