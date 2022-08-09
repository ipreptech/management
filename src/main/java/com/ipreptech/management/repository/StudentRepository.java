package com.ipreptech.management.repository;

import com.ipreptech.management.models.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    List<Student> studentList = new ArrayList<>() {{
        add(new Student("1", "riyaz", "ipt.gmail.com"));
        add(new Student("1", "srikanth", "ipt.srikanth.gmail.com"));
        add(new Student("2", "ramya", "ipt.ramya.gmail.com"));
        add(new Student("3", "afroz", "ipt.afroz.gmail.com"));
    }};

    public List<Student> getById(String id) {
        if (id.isEmpty()) {
            return studentList;
        }
        return this.studentList.stream().filter((s) -> s.getId().equals(id)).collect(Collectors.toList());
    }
}
