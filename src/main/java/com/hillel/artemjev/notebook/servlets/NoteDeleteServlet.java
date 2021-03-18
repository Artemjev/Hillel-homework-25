package com.hillel.artemjev.notebook.servlets;

import com.hillel.artemjev.notebook.dto.DeleteNoteRequest;
import com.hillel.artemjev.notebook.repository.UberFactory;
import com.hillel.artemjev.notebook.repository.note.NotesRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class NoteDeleteServlet extends JsonServlet {

    private NotesRepository notesRepository = UberFactory
            .instance()
            .getNotesRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Можно было передавать id как параметр в строке запроса, навереное...
        // Но, решил делать через тело (кажеться более правильным).
        DeleteNoteRequest deleteNoteRequest = readJson(DeleteNoteRequest.class, req);
        notesRepository.remove(deleteNoteRequest.getId());
    }
}
