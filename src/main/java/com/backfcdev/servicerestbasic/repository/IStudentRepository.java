package com.backfcdev.servicerestbasic.repository;

import com.backfcdev.servicerestbasic.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Long> {
    // Query Creation
    Student findByDni(String dni);
    boolean existsByDni(String dni);
}
