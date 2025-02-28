package com.example.demoacademia.service.Impl;

import com.example.demoacademia.model.Alumn;
import com.example.demoacademia.repository.IAlumnRepo;
import com.example.demoacademia.repository.IGenericRepo;
import com.example.demoacademia.service.IAlumnService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Service
@RequiredArgsConstructor
public class AlumnServiceImpl extends CRUDImpl<Alumn,Integer> implements IAlumnService {

    private final IAlumnRepo repo;

    @Override
    protected IGenericRepo<Alumn, Integer> getRepo() {
        return repo;
    }


    @Override
    public List<Alumn> ListStudents() {
        return repo.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Alumn::getAge).reversed()).
                collect(Collectors.toList());
    }
}
