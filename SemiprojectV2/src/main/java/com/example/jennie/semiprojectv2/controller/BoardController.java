package com.example.jennie.semiprojectv2.controller;

import com.example.jennie.semiprojectv2.domain.Board;
import com.example.jennie.semiprojectv2.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins ="http://localhost:5173")
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/write")
    public ResponseEntity<?> writeok(@RequestBody Board board) {

        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        log.info("submit된 게시글 정보 : {}", board);

        try {

            boardService.newBoard(board);
            response = ResponseEntity.ok().build();

        } catch (IllegalStateException ex) {

            response = ResponseEntity.badRequest().body(ex.getMessage());
        }

        return response;

    }

}
