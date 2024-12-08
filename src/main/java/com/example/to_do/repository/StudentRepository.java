package com.example.to_do.repository;

import com.example.to_do.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {
    Student findByName(String name);
}
