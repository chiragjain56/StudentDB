package com.sms.controller;

import com.sms.dto.StudentDTO;
import com.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping()
    public ResponseEntity<?> getAllStudentsHandler() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudentByIdHandler(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> saveStudentHandler(@RequestBody StudentDTO student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<?> updateStudentHandler(@RequestBody StudentDTO studentDTO, @PathVariable("id") Long id) {
        return new ResponseEntity<>(studentService.updateStudentById(studentDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudentHandler(@RequestBody StudentDTO studentDTO, @PathVariable("id") Long id) {
        return new ResponseEntity<>(studentService.deleteStudentById(studentDTO, id), HttpStatus.OK);
    }
}
