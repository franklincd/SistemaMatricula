package com.example.demoacademia.service;


import com.example.demoacademia.model.Matricula;

import java.util.List;
import java.util.Map;


public interface IMatriculaService extends ICRUD<Matricula,Integer>{

    /*Mostrar la relación de cursos matriculados y sus estudiantes correspondientes*/
    Map<String, List<String>> getCoursesEnrolledAlumn();

}
