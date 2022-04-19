package io.jegan.com.studentservice.controller;

import io.jegan.com.studentservice.entity.Student;
import io.jegan.com.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Value("instanceId")
    private String instanceId;

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<Student> findAllStudent(){
        return studentService.findAllStudent();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

      return ResponseEntity.ok().header("instance id",instanceId)
              .body(studentService.createStudent(student));
    }

    @DeleteMapping("/student/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@PathVariable Long id){
        studentService.deleteById(id);
    }
}
