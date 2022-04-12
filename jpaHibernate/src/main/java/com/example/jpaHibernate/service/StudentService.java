package com.example.jpaHibernate.service;

import com.example.jpaHibernate.repository.IStudentRepository;

public class StudentService{
    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


}
