package com.example.demoacademia.controller;

import com.example.demoacademia.dto.CourseDTO;
import com.example.demoacademia.model.Course;
import com.example.demoacademia.service.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {


    private final ICourseService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll()throws Exception{
        List<CourseDTO> list=service.finAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable("id") Integer id)throws Exception{
        Course obj=service.findById(id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    private ResponseEntity<CourseDTO> save(@Valid @RequestBody CourseDTO dto)throws Exception{
        Course obj=service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping(("/{id}"))
    private ResponseEntity<CourseDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody CourseDTO dto)throws Exception{
        Course obj=service.update(id,convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping(("/{id}"))
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*Metodos utilitarios*/
    private CourseDTO convertToDto(Course obj){
        return modelMapper.map(obj,CourseDTO.class);
    }

    private Course convertToEntity(CourseDTO dto){
        return modelMapper.map(dto,Course.class);
    }
}
