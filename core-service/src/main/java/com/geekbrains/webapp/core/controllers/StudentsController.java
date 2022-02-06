package com.geekbrains.webapp.core.controllers;

import com.geekbrains.webapp.core.model.Student;
import com.geekbrains.webapp.core.services.StudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentsController {
    private final StudentsService studentService;

    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    public Student save(@RequestBody @Validated Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        }
        studentService.save(student);
        return student;
    }

}
