package com.example.asn2.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{
    Student findByUid(int uid);
    
}
