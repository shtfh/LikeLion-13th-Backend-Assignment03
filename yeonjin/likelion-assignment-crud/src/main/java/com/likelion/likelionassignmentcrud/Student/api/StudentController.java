package com.likelion.likelionassignmentcrud.Student.api;

import com.likelion.likelionassignmentcrud.Student.api.dto.request.StudentRequest;
import com.likelion.likelionassignmentcrud.Student.api.dto.response.StudentResponse;
import com.likelion.likelionassignmentcrud.Student.application.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public StudentResponse createStudent(@RequestBody StudentRequest request) {
        return studentService.createStudent(request);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }
}
