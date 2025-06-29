package com.example.springbootproject.services;

import com.example.springbootproject.dto.BoardDTO;
import com.example.springbootproject.dto.NoteDTO;

import java.util.List;

public interface BoardService {
    BoardDTO createBoard(BoardDTO boardDTO);
    BoardDTO updateBoard(Long boardId, BoardDTO update);
    void deleteBoard(Long boardId);

    void addNoteOnBoard(Long boardId, Long noteId);
    List<NoteDTO> getNotesOnBoard(Long boardId);
    void removeNoteFromBoard(Long boardId, Long noteId);
}
