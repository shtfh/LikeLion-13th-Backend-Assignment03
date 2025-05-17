package com.likelion.likelionassignmentcrud.Assignment.api.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AssignmentRequest {
    private String title;
    private String content;
    private Long studentId;
}
