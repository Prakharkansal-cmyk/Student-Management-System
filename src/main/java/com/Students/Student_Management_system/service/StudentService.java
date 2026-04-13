package com.Students.Student_Management_system.service;

import com.Students.Student_Management_system.DTO.StudentDTO;
import com.Students.Student_Management_system.entity.Student;
import com.Students.Student_Management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentByName( String name){
        return studentRepository.findByName(name);
    }

    public List<Student> getStudentByAgeGreaterThan(int age){
         return studentRepository.findByAgeGreaterThan(age);
    }

    public List<Student>searchByName(String name){
      return studentRepository.searchByName(name);
    }

    public Student addStudent(StudentDTO studentDTO){
        Student student=modelMapper.map(studentDTO,Student.class);
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Student Not found"));
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

