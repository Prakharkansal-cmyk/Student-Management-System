package com.Students.Student_Management_system.controller;


import com.Students.Student_Management_system.DTO.StudentDTO;
import com.Students.Student_Management_system.entity.Student;
import com.Students.Student_Management_system.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
   private StudentService studentService;

    @GetMapping("/getAllStudents")
   public List<Student>getAllStudents(){
     return studentService.getAllStudents();
    }

    @PostMapping("/addStudent")
   public Student addStudent( @Valid  @RequestBody StudentDTO studentDTO){
        return studentService.addStudent(studentDTO);
    }

    @PutMapping("/updatedStudent/{id}")
    public Student updateStudent( @PathVariable Long id,@Valid @RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable Long id){
      return studentService.getStudentById(id);
    }

    @GetMapping("/getStudentByName/{name}")
    public List<Student> getStudentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping("/getStudentByAgeGreaterThan/{age}")
    public List<Student>getStudentByAgeGreaterThan(@PathVariable int age){
        return studentService.getStudentByAgeGreaterThan(age);
    }

    @GetMapping("/searchByName")
    public List<Student>searchByName(@RequestParam String name){
        return studentService.searchByName(name);
    }

    @GetMapping("/students/page")
    public Page<Student> getStudentWithPagination(@RequestParam int page, @RequestParam int size,@RequestParam String sortBy){
          return studentService.getStudentsWithPagination(page, size,sortBy);
    }

}
