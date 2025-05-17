package com.likelion.likelionassignmentcrud.Assignment.application;
//실제로 로직 처리는 곳
import com.likelion.likelionassignmentcrud.Assignment.api.dto.request.AssignmentRequest;
import com.likelion.likelionassignmentcrud.Assignment.api.dto.response.AssignmentResponse;
import com.likelion.likelionassignmentcrud.Assignment.domain.Assignment;
import com.likelion.likelionassignmentcrud.Assignment.domain.repository.AssignmentRepository;
import com.likelion.likelionassignmentcrud.Student.domain.Student;
import com.likelion.likelionassignmentcrud.Student.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final StudentRepository studentRepository;

    public AssignmentResponse createAssignment(AssignmentRequest request) {
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("학생을 찾을 수 없습니다."));

        Assignment assignment = Assignment.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .student(student)
                .build();

        return new AssignmentResponse(assignmentRepository.save(assignment));
    }

    public List<AssignmentResponse> getAllAssignments() {
        return assignmentRepository.findAll()
                .stream()
                .map(AssignmentResponse::new)
                .collect(Collectors.toList());
    }
}
