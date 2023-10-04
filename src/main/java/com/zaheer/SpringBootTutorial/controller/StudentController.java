package com.zaheer.SpringBootTutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zaheer.SpringBootTutorial.entity.Student;
import com.zaheer.SpringBootTutorial.exception.StudentIdMismatchException;
import com.zaheer.SpringBootTutorial.exception.StudentNotFoundException;
import com.zaheer.SpringBootTutorial.repository.StudentRepository;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(Student student)
    {
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id)
    {
        studentRepository.findById(id)
                .orElseThrow(StudentNotFoundException::new);
        studentRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Student updateBook(@RequestBody Student student, @PathVariable Long id) {
        if (student.getId() != id) {
            throw new StudentIdMismatchException();
        }
        studentRepository.findById(id)
                .orElseThrow(StudentNotFoundException::new);
        return studentRepository.save(student);
    }


    @GetMapping("/{id}")
    public Student find(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(StudentNotFoundException::new);
    }

    @GetMapping
    public Iterable findAll() {
        return studentRepository.findAll();
    }


    @GetMapping("/email/{emailId}")
    public List findByTitle(@PathVariable String emailId) {
        return studentRepository.findByEmailId(emailId);
    }

}
