package com.example.to_do.controller;

import com.example.to_do.entity.Student;
import com.example.to_do.service.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("academy/student")
public class StudentController {
    private final StudentServiceImpl studentServiceImpl;

    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @GetMapping("/info")
    public String index(Model model) {
        model.addAttribute("students", studentServiceImpl.findAll(null));
        return "index";
    }

    @GetMapping("/add-student")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentServiceImpl.saveInfo(student);
        return "redirect:/";
    }

    @GetMapping("/update-student/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        model.addAttribute("student", studentServiceImpl.findById(id));
        return "update-student";
    }

    @PostMapping("/update-student/{id}")
    public String updateStudent(@PathVariable long id, @ModelAttribute("student") Student updatedStudent) {
        studentServiceImpl.updateInfo(id, updatedStudent);
        return "redirect:/";
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable long id) {
        studentServiceImpl.deleteById(id);
        return "redirect:/";
    }
}
