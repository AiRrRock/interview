package com.geekbrains.webapp.core.services;

import com.geekbrains.webapp.core.model.Student;
import com.geekbrains.webapp.core.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentsService {
    private final StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

}
