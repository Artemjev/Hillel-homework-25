package com.hillel.artemjev.notebook.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DeleteNoteRequest {
    private Integer id;
}
