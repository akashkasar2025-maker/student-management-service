package com.studentmgmt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Student Data Transfer Object")
public class StudentDTO {

    @JsonProperty("id")
    @Schema(description = "Student ID", example = "1")
    private Long id;

    @JsonProperty("student_id")
    @Schema(description = "Student identifier", example = "STU001")
    private String studentId;

    @JsonProperty("student_name")
    @Schema(description = "Student name", example = "John Doe")
    private String studentName;

    @JsonProperty("grade")
    @Schema(description = "Student grade", example = "10-A")
    private String grade;

    @JsonProperty("mobile_number")
    @Schema(description = "Mobile number", example = "9876543210")
    private String mobileNumber;

    @JsonProperty("school_name")
    @Schema(description = "School name", example = "St. Xavier's School")
    private String schoolName;
}