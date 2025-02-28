package com.example.demoacademia.controller;

import com.example.demoacademia.dto.MatriculaDTO;
import com.example.demoacademia.model.Matricula;
import com.example.demoacademia.service.IMatriculaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {


    private final IMatriculaService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> findAll()throws Exception{
        List<MatriculaDTO> list=service.finAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDTO> findById(@PathVariable("id") Integer id)throws Exception{
        Matricula obj=service.findById(id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    private ResponseEntity<MatriculaDTO> save(@Valid @RequestBody MatriculaDTO dto)throws Exception{
        Matricula obj=service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping(("/{id}"))
    private ResponseEntity<MatriculaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody MatriculaDTO dto)throws Exception{
        Matricula obj=service.update(id,convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping(("/{id}"))
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    /* Query*/
    @GetMapping("/cursoalumno")
    public ResponseEntity<Map<String,List<String>>> getBestProduct() throws Exception{
        Map<String,List<String>> byProduct=service.getCoursesEnrolledAlumn();
        return ResponseEntity.ok(byProduct);
    }

    /*Metodos utilitarios*/
    private MatriculaDTO convertToDto(Matricula obj){
        return modelMapper.map(obj,MatriculaDTO.class);
    }

    private Matricula convertToEntity(MatriculaDTO dto){
        return modelMapper.map(dto,Matricula.class);
    }
}
