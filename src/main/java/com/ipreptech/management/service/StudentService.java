package com.ipreptech.management.service;

import com.ipreptech.management.models.Student;
import com.ipreptech.management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {

        this.repository = repository;
    }

    public List<Student> getStudentById(String id) {

        return repository.getById(id);
    }
    public List<Student> getStudentByName(String name) {

        return repository.getByName(name);
    }
    public List<Student> getStudentByEmail(String email) {

        return repository.getByEmail(email);
    }
    public List<Student> getStudentByAll(String id,String name,String email) {

        return repository.getByAll(id,name,email);
    }
}
