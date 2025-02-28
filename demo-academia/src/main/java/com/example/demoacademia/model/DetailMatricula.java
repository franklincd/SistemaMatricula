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
public class DetailMatricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDetailMatricula;

    @ManyToOne
    @JoinColumn(name="id_matricula",nullable = false,foreignKey = @ForeignKey(name="FK_DETAIL_MATRICULA"))
    private Matricula matricula;

    @ManyToOne
    @JoinColumn(name="id_course",nullable = false,foreignKey = @ForeignKey(name="FK_DETAIL_COURSE"))
    private Course course;

    @Column(nullable = false,length = 10)
    private String Aula;

}
