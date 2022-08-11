package com.ipreptech.management.controllers;

import com.ipreptech.management.models.Student;
import com.ipreptech.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("student")
    public List<Student> getStudent(@RequestParam(value = "id", required = false, defaultValue = "") String id,
                              @RequestParam(value = "name", required = false, defaultValue = "") String name,
                              @RequestParam(value = "email", required = false, defaultValue = "") String email) {

        if ((!id.isEmpty()) && (!name.isEmpty()) && (!email.isEmpty())) {

            return studentService.getStudentByAll(id, name, email);
        }
        if (!id.isEmpty()){

            return studentService.getStudentById(id);
        }
        if (!name.isEmpty()) {

            return studentService.getStudentByName(name);
        }
        if (!email.isEmpty()) {

            return studentService.getStudentByEmail(email);
        }

        return studentService.getStudentById(id);
    }


}
