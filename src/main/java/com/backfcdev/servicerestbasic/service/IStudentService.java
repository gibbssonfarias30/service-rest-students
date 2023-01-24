package com.backfcdev.servicerestbasic.service;

import com.backfcdev.servicerestbasic.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    Page<Student> findAll(Pageable pageable);
    Student save(Student student);
    Student findById(long id);
    Student findByDni(String dni);
    Student update(long id, Student student);
    void delete(long id);
}
