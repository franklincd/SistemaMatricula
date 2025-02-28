package com.example.demoacademia.service.Impl;

import com.example.demoacademia.model.Alumn;
import com.example.demoacademia.model.Course;
import com.example.demoacademia.model.DetailMatricula;
import com.example.demoacademia.model.Matricula;
import com.example.demoacademia.repository.IMatriculaRepo;
import com.example.demoacademia.repository.IGenericRepo;
import com.example.demoacademia.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl extends CRUDImpl<Matricula,Integer> implements IMatriculaService {

    private final IMatriculaRepo repo;

    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return repo;
    }

    @Override
    public Map<String, List<String>> getCoursesEnrolledAlumn() {

        Stream<Matricula> matriculaStream = repo.findAll().stream();

        return matriculaStream
                .flatMap(matricula -> matricula.getDetails().stream())
                .collect(Collectors.groupingBy(
                        detalle -> detalle.getCourse().getName(),
                        Collectors.mapping(detalle -> detalle.getMatricula().getAlumn().getFirsname(), Collectors.toList())
                ))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, java.util.LinkedHashMap::new));


    }
}
