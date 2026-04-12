package com.Students.Student_Management_system.repository;

import com.Students.Student_Management_system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByName(String name);
}
