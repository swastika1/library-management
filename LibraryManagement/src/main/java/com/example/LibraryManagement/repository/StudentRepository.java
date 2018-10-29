package com.example.LibraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryManagement.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByStudentname(String studentname);

}
