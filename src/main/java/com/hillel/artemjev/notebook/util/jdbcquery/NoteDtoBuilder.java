package com.hillel.artemjev.notebook.util.jdbcquery;

import com.hillel.artemjev.notebook.dto.AddNoteRequest;
import com.hillel.artemjev.notebook.entities.Note;

import java.time.LocalDateTime;

public class NoteDtoBuilder {

    public Note getNote(AddNoteRequest addNoteRequest) {
        return new Note().setName(addNoteRequest.getName())
                .setDescription(addNoteRequest.getDescription())
                .setDateTime(LocalDateTime.now());
    }
}
