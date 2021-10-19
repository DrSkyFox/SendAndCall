package com.example.les7.service;

import com.example.les7.repr.StudentRepr;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    Optional<StudentRepr> findStudentById(long id);

    List<StudentRepr> findAll();

    boolean deleteById(Long id);

    void saveOrUpdate(StudentRepr student);


}
