package com.studentmgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceiptDTO {
    private Long id;
    private String receiptNumber;
    private String studentId;
    private String studentName;
    private String schoolName;
    private Double feeAmount;
    private String paymentMethod;
    private String academicYear;
    private String feeType;
    private String remarks;
    private Long paymentDate;
}