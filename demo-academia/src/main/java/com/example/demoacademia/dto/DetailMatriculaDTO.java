package com.example.demoacademia.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetailMatriculaDTO {

    @JsonBackReference
    private MatriculaDTO matricula;

    @NotNull
    @JsonIncludeProperties(value = {"idCourse"})
    private CourseDTO course;

    @NotNull
    private String aula;
}
