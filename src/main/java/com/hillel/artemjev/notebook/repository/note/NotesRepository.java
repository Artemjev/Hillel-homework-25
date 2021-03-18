package com.hillel.artemjev.notebook.repository.note;

import com.hillel.artemjev.notebook.entities.Note;

import java.util.List;

public interface NotesRepository {
    void add(Note note);

    List<Note> getAll();

    void remove(Integer id);
}
