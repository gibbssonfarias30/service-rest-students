package com.backfcdev.servicerestbasic.service;

import com.backfcdev.servicerestbasic.exception.ExistingDni;
import com.backfcdev.servicerestbasic.exception.StudentNotFoundException;
import com.backfcdev.servicerestbasic.model.Student;
import com.backfcdev.servicerestbasic.repository.IStudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements IStudentService{
    private final IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        existsDni(student.getDni());
        return studentRepository.save(student);
    }

    @Override
    public Student findById(long id) {
        return getStudentById(id);
    }

    @Override
    public Student findByDni(String dni) {
        return studentRepository.findByDni(dni);
    }

    @Override
    public Student update(long id, Student student) {
        existsDni(student.getDni());
        return studentRepository.findById(id)
                .map(studentUpdate -> {
                    studentUpdate.setName(student.getName());
                    studentUpdate.setDni(student.getDni());
                    studentUpdate.setEmail(student.getEmail());
                    studentUpdate.setBirthDate(student.getBirthDate());
                    return studentRepository.save(studentUpdate);
                } )
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public void delete(long id) {
        getStudentById(id);
        studentRepository.deleteById(id);
    }

    public void existsDni(String dni) {
        boolean existsDni = studentRepository.existsByDni(dni);
        if(existsDni){
            throw new ExistingDni(dni);
        }
    }

    public Student getStudentById(long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }
}
