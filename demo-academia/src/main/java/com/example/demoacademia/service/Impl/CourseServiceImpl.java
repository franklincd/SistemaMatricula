package com.example.demoacademia.service.Impl;

import com.example.demoacademia.model.Course;
import com.example.demoacademia.repository.ICourseRepo;
import com.example.demoacademia.repository.IGenericRepo;
import com.example.demoacademia.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course,Integer> implements ICourseService {

    private final ICourseRepo repo;

    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }

}
