package com.example.springbootproject.controllers;

import com.example.springbootproject.dto.BoardDTO;
import com.example.springbootproject.dto.NoteDTO;
import com.example.springbootproject.services.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@AllArgsConstructor
public class BoardsController {
    private final BoardService service;

    @PostMapping("/create")
    public BoardDTO createBoard(@RequestBody BoardDTO boardDTO) {
        return service.createBoard(boardDTO);
    }

    @PutMapping("/update")
    public BoardDTO updateBoard(@RequestParam Long boardId, @RequestBody BoardDTO boardDTO) {
        return service.updateBoard(boardId, boardDTO);
    }

    @DeleteMapping("/delete")
    public void deleteBoard(@RequestParam Long boardId) {
        service.deleteBoard(boardId);
    }

    @PostMapping("/addNote")
    public void addNote(@RequestParam Long boardId, @RequestParam Long noteId) {
        service.addNoteOnBoard(boardId, noteId);
    }

    @GetMapping("/getNotes")
    public List<NoteDTO> getNotes(@RequestParam Long boardId) {
        return service.getNotesOnBoard(boardId);
    }

    @DeleteMapping("/removeNote")
    public void removeNote(@RequestParam Long boardId, @RequestParam Long noteId) {
        service.removeNoteFromBoard(boardId, noteId);
    }
}
