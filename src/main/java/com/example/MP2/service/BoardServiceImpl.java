package com.example.MP2.service;

import com.example.MP2.dto.BoardDTO;
import com.example.MP2.dto.PageRequestDTO;
import com.example.MP2.dto.PageResultDTO;
import com.example.MP2.entity.Board;
import com.example.MP2.entity.Region;
import com.example.MP2.entity.User;
import com.example.MP2.repository.BoardRepository;
import com.example.MP2.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    @Autowired
    private final BoardRepository repository;

    @Autowired
    private final ReplyRepository replyRepository;

    @Override
    public Long register(BoardDTO dto) {

        Board board = dtoToEntity(dto);
        repository.save(board);
        return board.getBno();
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {

        Function<Object[], BoardDTO> fn = (en -> entityToDTO((Board) en[0], (User) en[1], (Long) en[2]));

        // Page<Object[]> result = repository.getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("bno").descending()));

        Page<Object[]> result = repository.searchPage(
                pageRequestDTO.getType(),
                pageRequestDTO.getKeyword(),
                pageRequestDTO.getPageable(Sort.by("bno").descending()));

        return new PageResultDTO<>(result, fn);
    }

    @Override
    public BoardDTO get(Long Bno) {

        Object result = repository.getBoardEntityByBno(Bno);

        Object[] arr = (Object[]) result;

        return entityToDTO((Board)arr[0], (User)arr[1], (Region)arr[2], (Long)arr[3]);
    }

    @Transactional
    @Override
    public void removeWithReplies(Long bno) {

        replyRepository.deleteByBno(bno);

        repository.deleteById(bno);
    }

    @Override
    public void modify(BoardDTO boardDTO) {

        Board board = repository.getById(boardDTO.getBno());

        board.changeTitle(boardDTO.getTitle());
        board.changeContent(boardDTO.getContents());

        repository.save(board);
    }
}
