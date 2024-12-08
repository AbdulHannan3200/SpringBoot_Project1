package com.example.to_do.service;

import com.example.to_do.entity.Student;
import com.example.to_do.repository.StudentRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveInfo(Student info){
        return studentRepository.save(info);
    }
    public List<Student> findAll(Student info){
        return studentRepository.findAll();
    }
    public Student findById(long id){
        return studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Student with id : "+id +" is not found!")) ;
    }
    public Student findByName(String name){
        return studentRepository.findByName(name);
    }
    public Student updateInfo(long id, Student updatedStudent) {
        // Fetch the existing student or throw an exception if not found
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with this id is not found here!"));

        // Update the fields of the existing student with the new data
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setEducation(updatedStudent.getEducation());
        existingStudent.setActivity(updatedStudent.getActivity());

        // Save the updated student back to the database
        return studentRepository.save(existingStudent);
    }

    public void deleteById(long id){
        studentRepository.deleteById(id);
    }

}
