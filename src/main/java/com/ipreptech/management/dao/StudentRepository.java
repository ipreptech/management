package com.ipreptech.management.dao;

import com.google.common.collect.Lists;
import com.ipreptech.management.entities.Student;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    default List<Student> findAllByIdAndEmailAndName(Long id, String email, String name) {

        if (id != null && id != 0) {
            return (List<Student>) findAllById(Lists.newArrayList(id));
        }

        if (StringUtils.hasLength(email) && StringUtils.hasLength(name)) {
            return findAllByEmailAndName(email, name);
        } else if (StringUtils.hasLength(email)) {
            return findAllByEmail(email);
        } else if (StringUtils.hasLength(name)) {
            return finalAllByName(name);
        }

        return (List<Student>) findAll();
    }

    @Query("from Student s where s.email=:email and s.firstName=:name")
    List<Student> findAllByEmailAndName(@Param("email") String email, @Param("name") String name);


    @Query("from Student s where s.email=:email")
    List<Student> findAllByEmail(@Param("email") String email);

    @Query("from Student s where s.firstName=:name")
    List<Student> finalAllByName(@Param("name") String name);
}
