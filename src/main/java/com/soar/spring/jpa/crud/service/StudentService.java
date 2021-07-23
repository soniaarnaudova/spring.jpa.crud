package com.soar.spring.jpa.crud.service;

import com.soar.spring.jpa.crud.entity.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentService {
    public Student saveStudent(Student student);

    public Student deleteStudent(Student student);

    public Student updateStudent(Student student);

    public Student getStudent(Long id);

}
