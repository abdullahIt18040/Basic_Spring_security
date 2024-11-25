package com.jwtapi.jwtapi.controllers;

import com.jwtapi.jwtapi.entityes.Student;
import com.jwtapi.jwtapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    StudentService studentService;
    @GetMapping("/home")
    public  String displayHome(){
        return  "my home controller ";
    }
    @PostMapping("/addStudent")
    public String saveStudent(@RequestBody Student student){
      Student student1 =  studentService.saveStudent(student);
      if(student1 !=null)
      {
          return "save student successfully";
      }
        return  "student not save";
    }
    @PostMapping("/updatestudent")
    public  String updateStudent (@RequestBody Student student)
    {

       Student student1 = studentService.updateStudent(student);
       if(student1 !=null){
           return " update  successfully";
       }
       return "not update";
    }
    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }


}
