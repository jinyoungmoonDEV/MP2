package com.example.MP2.repository;

import com.example.MP2.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{
    // 한개의 로우(object) 내에 Object[]로 나옴
    // Board를 사용하고 있지만 Member를 같이 조회해야 하는 상황에서 사용
    @Query("select b, u from Board  b left join b.user u where b.bno =:bno")
    Object getBoardWithUser(@Param("bno") Long bno);

    @Query("select b, g from Board b left join b.region g where b.bno =:bno")
    Object getBoardWithRegion(@Param("bno") Long bno);

    @Query("select b, r from Board b left join Reply r on r.bno = b where b.bno =:bno")
    List<Object[]> getBoardWithReply(@Param("bno") Long bno);

    @Query("select b, u, count(r)" +
            " from Board b left join b.user u " +
            " left outer join Reply  r on r.bno = b " +
            " where  b.bno = :bno")
    Object getBoardEntityByBno(@Param("bno") Long bno);

    @Query("SELECT b, u, count(r) " +
            " FROM Board b LEFT JOIN b.user u " +
            " LEFT OUTER JOIN Reply r ON r.board = b" +
            " WHERE b.bno = :bno")
    Object getBoardByBno(@Param("bno") Long bno);
}
