package com.hillel.artemjev.notebook.servlets;

import com.hillel.artemjev.notebook.dto.AddNoteRequest;
import com.hillel.artemjev.notebook.dto.GetNotesResponse;
import com.hillel.artemjev.notebook.entities.Note;
import com.hillel.artemjev.notebook.repository.UberFactory;
import com.hillel.artemjev.notebook.repository.note.NotesRepository;
import com.hillel.artemjev.notebook.util.jdbcquery.NoteDtoBuilder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class NoteServlet extends JsonServlet {

    private NotesRepository notesRepository = UberFactory
            .instance()
            .getNotesRepository();

//    private NoteDtoBuilder noteDtoBuilder = UberFactory
//            .instance()
//            .getNoteDtoBuilder();

    private NoteDtoBuilder noteDtoBuilder = new NoteDtoBuilder();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Note> notes = notesRepository.getAll();

        //        https://prnt.sc/10pe590
        // Может из методов JdbcTemplate нужно было пробрасывать SQLException аж в сервлет,
        // и возвращать статус в ответе на основании исключения?  хз, но кажеться не очень правильным.
        if (notes == null) {
            writeJson(
                    new GetNotesResponse()
                            .setError("DID NOT RECEIVE DATA")
                            .setStatus("fail"),
                    resp
            );
        } else {
            if (!notes.isEmpty()) {
                writeJson(
                        new GetNotesResponse()
                                .setNotes(notes)
                                .setStatus("ok"),
                        resp
                );
            } else {
                writeJson(
                        new GetNotesResponse()
                                .setError("THERE ARE NO NOTES")
                                .setStatus("ok"),
                        resp
                );
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        AddNoteRequest addNoteRequest = readJson(AddNoteRequest.class, req);
        Note note = noteDtoBuilder.getNote(addNoteRequest); // - возможно это стоило  конвертировать в репозитории?
        // возможно вообще не стоило заморачиваться с AddNoteRequest (просто Note сразу из реквеста доставать),
        // но разделение слоев вроде...
        notesRepository.add(note);
        // Тут, поидее, нужно возращать StatusResponse (получилось добавить или нет).
        // В голове каша из нескольких идей.. решил не делать)) время... та и хз как это сделать правильно.
        // (например, возвращать из метода update() класса JdbcTemplate -> true/false - поймали/не_поймали исключение
        // + в NotesRepository  add(Note note), что бы тоже boolean возвращал  https://prnt.sc/10peccg
        // или вобще после добавления, проверять выборкой по идишнику есть ли он в базе)
    }
}
