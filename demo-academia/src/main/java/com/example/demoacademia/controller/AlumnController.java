package com.example.demoacademia.controller;

import com.example.demoacademia.dto.AlumnDTO;
import com.example.demoacademia.model.Alumn;
import com.example.demoacademia.service.IAlumnService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumns")
@RequiredArgsConstructor
public class AlumnController {


    private final IAlumnService service;

    @Qualifier("alumnMapper")
    private final ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<List<AlumnDTO>> findAll()throws Exception{
        List<AlumnDTO> list=service.finAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnDTO> findById(@PathVariable("id") Integer id)throws Exception{
        Alumn obj=service.findById(id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    private ResponseEntity<AlumnDTO> save(@Valid @RequestBody AlumnDTO dto)throws Exception{
        Alumn obj=service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping(("/{id}"))
    private ResponseEntity<AlumnDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody AlumnDTO dto)throws Exception{
        Alumn obj=service.update(id,convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping(("/{id}"))
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*Querys*/

    @GetMapping("/listalumn")
    public ResponseEntity<List<AlumnDTO>> getListStudents() throws Exception{
        List<AlumnDTO> lista=service.ListStudents().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(lista);
    }

    /*Metodos utilitarios*/
    private AlumnDTO convertToDto(Alumn obj){
        return modelMapper.map(obj,AlumnDTO.class);
    }

    private Alumn convertToEntity(AlumnDTO dto){
        return modelMapper.map(dto,Alumn.class);
    }


}
