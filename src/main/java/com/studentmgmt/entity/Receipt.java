package com.studentmgmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "receipts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String receiptNumber;

    @Column(nullable = false)
    private String studentId;

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false)
    private String grade;

    @Column(nullable = false)
    private String mobileNumber;

    @Column(nullable = false)
    private String schoolName;

    @Column(nullable = false)
    private Double feeAmount;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private String academicYear;

    @Column(nullable = false)
    private String feeType;

    @Column(nullable = false)
    private String status;

    @Column(length = 500)
    private String remarks;

    @Column(name = "payment_date")
    private Long paymentDate;

    @Column(name = "issued_date")
    private Long issuedDate;

    @Column(name = "created_at")
    private Long createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = System.currentTimeMillis();
        issuedDate = System.currentTimeMillis();
        if (paymentDate == null) {
            paymentDate = System.currentTimeMillis();
        }
    }
}