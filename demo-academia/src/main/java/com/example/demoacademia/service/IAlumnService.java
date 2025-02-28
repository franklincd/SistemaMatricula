package com.example.demoacademia.service;


import com.example.demoacademia.model.Alumn;

import java.util.List;


public interface IAlumnService extends ICRUD<Alumn,Integer>{

    /*Listar estudiantes ordenados de forma descendente por edad usando programación funcional */
    List<Alumn> ListStudents();

}
