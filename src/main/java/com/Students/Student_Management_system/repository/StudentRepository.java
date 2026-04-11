package com.Students.Student_Management_system.repository;

import com.Students.Student_Management_system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
