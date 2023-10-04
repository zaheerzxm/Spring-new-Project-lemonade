package com.zaheer.SpringBootTutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaheer.SpringBootTutorial.entity.Student;

import java.util.List;

public interface StudentRepository  extends JpaRepository<Student, Long> {

    List<Student> findByEmailId(String emailId);
}
