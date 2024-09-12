package com.ipreptech.management.service;

import com.ipreptech.management.dao.StudentRepository;
import com.ipreptech.management.exceptions.StudentNotFoundException;
import com.ipreptech.management.models.Student;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentService extends Mapper<Student, com.ipreptech.management.entities.Student> {

    @Autowired
    private StudentRepository repository;

    public Student getStudentById(Long id) {
        com.ipreptech.management.entities.Student student = this.repository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException(
                String.format("Student with id: %d not found", id)));
        return entityToModel(student);
    }

    public List<Student> getStudentByIdAndEmailAndName(Long id, String email, String name) {
        log.info("Received values id: {}, email: {}, name: {}", id, email, name);
        List<com.ipreptech.management.entities.Student> students =
            this.repository.findAllByIdAndEmailAndName(id, email, name);
        return mapEntityListToModelList(students);
    }

    public Student saveStudent(Student studentModel) {
        com.ipreptech.management.entities.Student s = repository.save(modelToEntity(studentModel));
        return entityToModel(s);
    }

    @Override
    public Student entityToModel(com.ipreptech.management.entities.Student studentEntity) {
        return Student.builder()
            .firstName(studentEntity.getFirstName())
            .id(studentEntity.getId())
            .gender(studentEntity.getGender())
            .email(studentEntity.getEmail())
            .lastName(studentEntity.getLastName())
            .build();
    }

    @Override
    public com.ipreptech.management.entities.Student modelToEntity(Student studentModel) {
        return com.ipreptech.management.entities.Student.builder()
            .firstName(studentModel.getFirstName())
            .id(studentModel.getId())
            .gender(studentModel.getGender())
            .email(studentModel.getEmail())
            .lastName(studentModel.getLastName())
            .build();
    }
}
