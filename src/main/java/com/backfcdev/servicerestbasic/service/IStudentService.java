package com.backfcdev.servicerestbasic.service;

import com.backfcdev.servicerestbasic.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student save(Student student);
    Student findById(long id);
    Student findByDni(String dni);
    Student update(long id, Student student);
    void delete(long id);
}
