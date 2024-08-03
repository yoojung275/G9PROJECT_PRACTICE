package org.g9project4.board.services;

import lombok.RequiredArgsConstructor;
import org.g9project4.board.controllers.RequestBoard;
import org.g9project4.board.entities.BoardData;
import org.g9project4.board.repositories.BoardDataRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BoardSaveService {

    private final BoardDataRepository boardDataRepository;

    private void save(RequestBoard form) {
        Long id = Objects.requireNonNullElse(form.getId(), 0L);
        BoardData boardData = boardDataRepository.findById(id).orElseGet(BoardData::new);

        boardData.setTitle(form.getTitle());
        boardData.setContent(form.getContent());
        boardData.setAuthor(form.getAuthor());

        boardDataRepository.saveAndFlush(boardData);
    }
}
