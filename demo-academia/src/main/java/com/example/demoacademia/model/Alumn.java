package com.example.demoacademia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Alumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idAlumn;

    @Column(nullable = false,length = 50)
    private String firsname;

    @Column(nullable = false,length = 50)
    private String lastname;

    @Column(nullable = false,length = 12)
    private String dni;

    @Column(nullable = false)
    private Integer age;
}
