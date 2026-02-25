package com.studentmgmt.service;

import com.studentmgmt.entity.FeeCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeeCollectionRepository extends JpaRepository<FeeCollection, Long> {
    Optional<FeeCollection> findByReceiptNumber(String receiptNumber);
    List<FeeCollection> findByStudentId(String studentId);
    List<FeeCollection> findByAcademicYear(String academicYear);
}