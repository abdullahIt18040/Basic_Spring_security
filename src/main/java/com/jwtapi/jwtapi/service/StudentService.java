package com.jwtapi.jwtapi.service;

import com.jwtapi.jwtapi.entityes.Student;
import com.jwtapi.jwtapi.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Student saveStudent(Student student)
    {
        return  studentRepository.save(student);

    }
    @Transactional
    public  Student updateStudent(Student student)
    {
        Student existingStudent = studentRepository.findByEmail(student.getEmail());

        // Check if the student exists
        if (existingStudent == null) {
            throw new RuntimeException("Student with email " + student.getEmail() + " not found");
        }
        existingStudent.setName(student.getName());
        existingStudent.setPassword(student.getPassword());
       return studentRepository.save(existingStudent);

    }
    public List<Student> getAllStudent(){
        return  studentRepository.findAll();
    }


}
