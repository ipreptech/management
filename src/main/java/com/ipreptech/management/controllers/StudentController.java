package com.ipreptech.management.controllers;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_OK;

import com.ipreptech.management.models.Student;
import com.ipreptech.management.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Student Controller")
@RestController
@RequestMapping(value = "/api/student")
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;

    @ApiOperation(value = "Student GET mapping")
    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "ok"),
        @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error")
    })
    @GetMapping("/{id}")
    @CrossOrigin(origins = {"*"})
    public Student getStudent(@PathVariable(value = "id", required = true) Long id) {
        return studentService.getStudentById(id);
    }

    @ApiOperation(value = "Student GET mapping")
    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "ok"),
        @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error")
    })
    @GetMapping
    @CrossOrigin(origins = {"*"})
    public List<Student> getStudent(
        @RequestParam(value = "id", required = false, defaultValue = "") Long id,
        @RequestParam(value = "email", required = false, defaultValue = "") String email,
        @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        return studentService.getStudentByIdAndEmailAndName(id, email, name);
    }

    @ApiOperation(value = "Student Post mapping")
    @ApiResponses(value = {@ApiResponse(code = SC_OK, message = "ok"),
        @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error")
    })
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        log.info("Student: {}", student);
        return studentService.saveStudent(student);
    }
}
