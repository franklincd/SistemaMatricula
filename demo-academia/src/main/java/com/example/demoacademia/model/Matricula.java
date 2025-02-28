package com.example.demoacademia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMatricula;

    @ManyToOne
    @JoinColumn(name="id_alumn",nullable = false,foreignKey = @ForeignKey(name="FK_MATRICULA_ALUMNO"))
    private Alumn alumn;

    @Column(nullable = false)
    private LocalDateTime dateTimeMatricula;

    @Column(nullable = false)
    private boolean enabled;

    @OneToMany(mappedBy = "matricula",cascade = CascadeType.ALL)
    private List<DetailMatricula> details;
}
