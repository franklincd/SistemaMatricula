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
public class AlumnDTO {

    private Integer idAlumn;

    @NotNull
    @Size(min = 3, max = 50)
    private String firstnameAlumn;

    @NotNull
    @Size(min = 3, max = 50)
    private String lastnameAlumn;

    @NotNull
    @Size(min = 1, max = 10)
    private String dniAlumn;

    @NotNull
    private Integer ageAlumn;
}
