package com.soar.spring.jpa.crud.service;

import com.soar.spring.jpa.crud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    @Transactional
    public Student deleteStudent(Student student) {
        if(entityManager.contains(student)){
            entityManager.remove(student);
        }else{
            entityManager.remove(entityManager.merge(student));
        }
        return student;
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        entityManager.merge(student);
        return student;
    }

    @Override
    public Student getStudent(Long id) {
        return entityManager.find(Student.class, id);
    }
}
