package com.example.jpaHibernate.repository;

import com.example.jpaHibernate.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Long> {

}
