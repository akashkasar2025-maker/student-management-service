package com.studentmgmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fee_collections")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeeCollection {

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
    private String schoolName;

    @Column(nullable = false)
    private Double feeAmount;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private String academicYear;

    @Column(nullable = false)
    private String feeType;

    @Column
    private String remarks;

    @Column(name = "payment_date")
    private Long paymentDate;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = System.currentTimeMillis();
        updatedAt = System.currentTimeMillis();
        paymentDate = System.currentTimeMillis();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = System.currentTimeMillis();
    }
}