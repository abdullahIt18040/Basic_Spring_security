package com.jwtapi.jwtapi.repositories;

import com.jwtapi.jwtapi.entityes.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    // Method to find a student by their email
    Student findByEmail(String email);


}
