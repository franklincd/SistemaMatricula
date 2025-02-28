package com.example.demoacademia.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDTO {
    private Integer idMatricula;

    @NotNull
    @JsonIncludeProperties(value = {"idAlumn"})
    private AlumnDTO alumn;

    @NotNull
    private LocalDateTime dateTimeMatricula;

    @NotNull
    private boolean enabledMatricula;

    @NotNull
    @JsonManagedReference
    private List<DetailMatriculaDTO> detailsMatricula;
}
