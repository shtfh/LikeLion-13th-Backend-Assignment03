package com.likelion.likelionassignmentcrud.Student.application;

import com.likelion.likelionassignmentcrud.Student.api.dto.request.StudentRequest;
import com.likelion.likelionassignmentcrud.Student.api.dto.response.StudentResponse;
import com.likelion.likelionassignmentcrud.Student.domain.Student;
import com.likelion.likelionassignmentcrud.Student.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentResponse createStudent(StudentRequest request) {
        Student student = Student.builder()
                .name(request.getName())
                .major(request.getMajor())
                .build();
        return new StudentResponse(studentRepository.save(student));
    }

    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentResponse::new)
                .collect(Collectors.toList());
    }
}
