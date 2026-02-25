package com.studentmgmt.service;

import com.studentmgmt.dto.FeeCollectionDTO;
import com.studentmgmt.dto.ReceiptDTO;
import java.util.List;

public interface FeeCollectionService {
    ReceiptDTO collectFee(FeeCollectionDTO feeCollectionDTO);
    ReceiptDTO getReceiptByNumber(String receiptNumber);
    List<ReceiptDTO> getReceiptsByStudentId(String studentId);
    List<ReceiptDTO> getReceiptsByAcademicYear(String academicYear);
    List<ReceiptDTO> getAllReceipts();
}