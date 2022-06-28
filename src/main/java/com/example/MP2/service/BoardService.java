package com.example.MP2.service;

import com.example.MP2.dto.BoardDTO;
import com.example.MP2.dto.PageRequestDTO;
import com.example.MP2.dto.PageResultDTO;
import com.example.MP2.entity.Board;
import com.example.MP2.entity.Region;
import com.example.MP2.entity.User;

public interface BoardService {

    Long register(BoardDTO dto);

    default Board dtoToEntity(BoardDTO dto) {

        User user = User.builder().userid(dto.getUserid()).build();
        Region region = Region.builder().rcode(dto.getRcode()).build();

        Board board = Board.builder()
                .bno(dto.getBno())
                .region(region)
                .title(dto.getTitle())
                .contents(dto.getContents())
                .image(dto.getImage())
                .user(user)
                .build();
        return board;
    }

    BoardDTO get(Long Bno);
    // 목록처리
    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    default BoardDTO entityToDTO(Board board, User user, Region region, Long replyCount){

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(board.getBno())
                .rcode(region.getRcode())
                .title(board.getTitle())
                .contents(board.getContents())
                .image(board.getImage())
                .userid(user.getUserid())
                .build();
        return boardDTO;
    }

    void modify(BoardDTO boardDTO);

    void removeWithReplies(Long Bno);
}
