package com.hillel.artemjev.notebook.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hillel.artemjev.notebook.entities.Note;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Accessors(chain = true)
public class GetNotesResponse {
    private String status;
    private String error;
    private List<Note> notes;
}
