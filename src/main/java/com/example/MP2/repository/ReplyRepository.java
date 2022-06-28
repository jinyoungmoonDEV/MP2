package com.example.MP2.repository;

import com.example.MP2.entity.Reply;
import com.example.MP2.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
        // Board 삭제시 댓글들 삭제
        @Modifying
        @Query("delete from Reply r where r.board.bno =:bno ")
        void deleteByBno(@Param("bno")Long bno);

        // 게시물로 댓글 목록 가져오기
        List<Reply> getRepliesByBoardOrderByRno(Board board);
}
