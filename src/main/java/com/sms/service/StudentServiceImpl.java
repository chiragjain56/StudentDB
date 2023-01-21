package com.sms.service;

import com.sms.dto.StudentDTO;
import com.sms.entity.Student;
import com.sms.exception.StudentException;
import com.sms.modelmapper.ModelMapperClass;
import com.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        StudentDTO studentDTO = new StudentDTO();
        studentRepository.findById(id).orElseThrow(() -> new StudentException("Student is not found with id:-" + id));
        ModelMapperClass.modelMapper().map(studentRepository.findById(id).get(), studentDTO);
        return studentDTO;
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student st = new Student();
//        st.setFirstName(studentDTO.getFirstName());
        ModelMapperClass.modelMapper().map(studentDTO, st);
        studentRepository.save(st);
        return studentDTO;
    }

    @Override
    public StudentDTO deleteStudentById(StudentDTO studentDTO, Long id) {
        Student st = studentRepository.findById(id).orElseThrow(() -> new StudentException("Student is not found with id:-" + id));
        ModelMapperClass.modelMapper().map(studentDTO, st);
        studentRepository.deleteById(id);
        return studentDTO;
    }

    @Override
    public StudentDTO updateStudentById(StudentDTO studentDTO, Long id) {
        Student st = studentRepository.findById(id).orElseThrow(() -> new StudentException("Student is not found with id:-" + id));
        ModelMapperClass.modelMapper().map(studentDTO, st);
        studentRepository.save(st);
        return studentDTO;
    }
}
