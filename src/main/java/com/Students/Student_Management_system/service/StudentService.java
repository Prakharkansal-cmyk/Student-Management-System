package com.Students.Student_Management_system.service;

import com.Students.Student_Management_system.entity.Student;
import com.Students.Student_Management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id,Student updatedStudent){
           Student existing=studentRepository.findById(id)
                   .orElseThrow(()->new RuntimeException("Student Not Found"));
           existing.setName(updatedStudent.getName());
           existing.setEmail(updatedStudent.getEmail());
           existing.setAge(updatedStudent.getAge());

           return studentRepository.save(existing);
        }

        public void deleteStudent(Long id){
          studentRepository.deleteById(id);
        }
    }

