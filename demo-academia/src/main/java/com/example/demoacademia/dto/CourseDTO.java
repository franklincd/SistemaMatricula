package com.example.demoacademia.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {
    private Integer idCourse;

    @NotNull
    @Size(min =3,max = 50)
    private String  nameCourse;

    @NotNull
    @Size(min = 1,max = 10)
    private String  siglaCourse;

    @NotNull
    private boolean enabledCourse;
}
