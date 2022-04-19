package io.jegan.com.studentservice.service;

import io.jegan.com.studentservice.Repo.StudentRepo;
import io.jegan.com.studentservice.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> findAllStudent(){
        return studentRepo.findAll();
    }

    public Optional<Student> findById(Long id){
        return studentRepo.findById(id);
    }

    public Student createStudent(Student student){
        return studentRepo.save(student);
    }

    public void deleteById(Long id){
        studentRepo.deleteById(id);
    }
}
