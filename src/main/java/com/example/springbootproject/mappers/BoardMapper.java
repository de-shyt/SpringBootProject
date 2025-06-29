package com.example.springbootproject.mappers;

import com.example.springbootproject.dto.BoardDTO;
import com.example.springbootproject.entities.Board;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = NoteMapper.class)
public interface BoardMapper {
    BoardDTO toBoardDTO(Board board);
    Board toBoard(BoardDTO boardDTO);
}
