package com.example.les7.serviceimplementation;

import com.example.les7.entities.Student;
import com.example.les7.exceptions.NotFoundException;
import com.example.les7.repository.StudentRepository;
import com.example.les7.repr.StudentRepr;
import com.example.les7.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
public class StudentService implements IStudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<StudentRepr> findStudentById(long id) {
        log.info("Get Student by ID {}}", id);
        return repository.findById(id).map(StudentRepr::new);
    }

    @Override
    public List<StudentRepr> findAll() {
        log.info("Find ALL Students");
        return repository.findAll().stream().map(StudentRepr::new).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public boolean deleteById(Long id) {
        log.info("delete student by id {}}", id);
        if(!repository.findById(id).isEmpty()) {
            repository.deleteById(id);
            log.info("Student by Id {} deleted", id);
            return true;
        }
        log.info("Student not found");
        return false;
    }

    @Transactional
    @Override
    public void saveOrUpdate(StudentRepr student) {
        Student studentToSave = new Student(student);
        log.info("Student {} save", student.toString());
        repository.save(studentToSave);
        if(student.getId() == null) {
            student.setId(studentToSave.getId());
        }

    }


}
