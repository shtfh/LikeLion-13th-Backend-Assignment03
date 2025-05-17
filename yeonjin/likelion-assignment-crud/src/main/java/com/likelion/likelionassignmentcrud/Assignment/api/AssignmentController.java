package com.likelion.likelionassignmentcrud.Assignment.api;

import com.likelion.likelionassignmentcrud.Assignment.api.dto.request.AssignmentRequest;
import com.likelion.likelionassignmentcrud.Assignment.api.dto.response.AssignmentResponse;
import com.likelion.likelionassignmentcrud.Assignment.application.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    @PostMapping
    public AssignmentResponse createAssignment(@RequestBody AssignmentRequest request) {
        return assignmentService.createAssignment(request);
    }

    @GetMapping
    public List<AssignmentResponse> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }
}
