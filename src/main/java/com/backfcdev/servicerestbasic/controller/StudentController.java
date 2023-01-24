package com.backfcdev.servicerestbasic.controller;

import com.backfcdev.servicerestbasic.model.Student;
import com.backfcdev.servicerestbasic.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final IStudentService studentService;
    private final static HashMap<String, Object> response = new HashMap<>();

    @GetMapping
    ResponseEntity<Page<Student>> index(
            @PageableDefault(size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return ResponseEntity.ok(studentService.findAll(pageable));
    }

    @GetMapping("/{dni}")
    ResponseEntity<Student> getStudentByDni(@PathVariable String dni){
        return ResponseEntity.ok(studentService.findByDni(dni));
    }

    @PostMapping
    ResponseEntity<HashMap<String, Object>> saveStudent(@RequestBody Student student){
        response.put("student", studentService.save(student));
        response.put("message", "Student successfully added");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<HashMap<String, Object>> updateStudent(@PathVariable Long id, @RequestBody Student student){
        response.put("student", studentService.update(id, student));
        response.put("message", "Student successfully updated");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<HashMap<String, Object>> deleteStudentById(@PathVariable Long id){
        studentService.delete(id);
        response.put("message", "Student successfully deleted");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
