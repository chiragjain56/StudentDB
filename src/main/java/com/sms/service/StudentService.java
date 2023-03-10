package com.sms.service;

import com.sms.dto.StudentDTO;
import com.sms.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public StudentDTO getStudentById(Long id);

    public StudentDTO saveStudent(StudentDTO student);

    public StudentDTO deleteStudentById(StudentDTO studentDTO, Long id);

    public StudentDTO updateStudentById(StudentDTO studentDTO, Long id);
}
