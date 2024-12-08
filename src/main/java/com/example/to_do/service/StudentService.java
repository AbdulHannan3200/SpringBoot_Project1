package com.example.to_do.service;

import com.example.to_do.entity.Student;

import java.util.List;

public interface StudentService {
    public Student saveInfo(Student info);
    public List<Student> findAll(Student info);
    public Student findById(Long id);
    public Student updateInfo(Long id , Student updateStudent);
    public void deleteById(Long id);
}
