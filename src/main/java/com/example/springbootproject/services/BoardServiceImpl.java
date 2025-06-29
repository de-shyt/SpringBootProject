package com.example.springbootproject.services;

import com.example.springbootproject.dto.BoardDTO;
import com.example.springbootproject.dto.NoteDTO;
import com.example.springbootproject.entities.Board;
import com.example.springbootproject.entities.Note;
import com.example.springbootproject.exceptions.BoardNotFoundException;
import com.example.springbootproject.exceptions.NoteNotFoundException;
import com.example.springbootproject.mappers.BoardMapper;
import com.example.springbootproject.mappers.NoteMapper;
import com.example.springbootproject.repositories.BoardRepo;
import com.example.springbootproject.repositories.NoteRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,  makeFinal = true)
public class BoardServiceImpl implements BoardService {
    BoardRepo boardRepo;
    BoardMapper boardMapper;
    NoteRepo noteRepo;
    NoteMapper noteMapper;

    @Override
    public BoardDTO createBoard(BoardDTO boardDTO) {
        Board board = boardMapper.toBoard(boardDTO);
        Board saved = boardRepo.save(board);
        return boardMapper.toBoardDTO(saved);
    }

    @Override
    public BoardDTO updateBoard(Long boardId, BoardDTO update) {
        Board board = boardRepo.findWithNotesById(boardId)
                .orElseThrow(() -> new BoardNotFoundException(boardId));

        if (update.getOwnerId() != null) board.setOwnerId(update.getOwnerId());
        if (update.getDescription() != null) board.setDescription(update.getDescription());
        Board saved = boardRepo.save(board);

        return boardMapper.toBoardDTO(saved);
    }

    @Override
    public void deleteBoard(Long boardId) {
        boardRepo.deleteById(boardId);
    }

    @Override
    public void addNoteOnBoard(Long boardId, Long noteId) {
        Board board = boardRepo.findWithNotesById(boardId)
                .orElseThrow(() ->  new BoardNotFoundException(boardId));
        Note note = noteRepo.findById(noteId)
                .orElseThrow(() -> new NoteNotFoundException(noteId));
        board.getNotes().add(note);
        boardRepo.save(board);
    }

    @Override
    public List<NoteDTO> getNotesOnBoard(Long boardId) {
        Board board = boardRepo.findWithNotesById(boardId)
                .orElseThrow(() -> new BoardNotFoundException(boardId));
        return noteMapper.toNoteDTO(board.getNotes());
    }

    @Override
    public void removeNoteFromBoard(Long boardId, Long noteId) {
        Board board = boardRepo.findWithNotesById(boardId)
                .orElseThrow(() ->  new BoardNotFoundException(boardId));
        board.getNotes().removeIf(note -> note.getId().equals(noteId));
        boardRepo.save(board);
    }
}
