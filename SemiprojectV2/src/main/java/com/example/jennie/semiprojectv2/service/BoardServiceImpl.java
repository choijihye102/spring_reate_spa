package com.example.jennie.semiprojectv2.service;

import com.example.jennie.semiprojectv2.domain.Board;
import com.example.jennie.semiprojectv2.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;


    @Override
    public Board newBoard(Board board) {

        return boardRepository.save(board);
    }
}
