package com.studentmgmt.service.impl;

import com.studentmgmt.dto.FeeCollectionDTO;
import com.studentmgmt.dto.ReceiptDTO;
import com.studentmgmt.entity.FeeCollection;
import com.studentmgmt.repository.FeeCollectionRepository;
import com.studentmgmt.service.FeeCollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeeCollectionServiceImpl implements FeeCollectionService {

    private final FeeCollectionRepository feeCollectionRepository;

    @Override
    public ReceiptDTO collectFee(FeeCollectionDTO feeCollectionDTO) {
        FeeCollection feeCollection = FeeCollection.builder()
                .receiptNumber(feeCollectionDTO.getReceiptNumber())
                .studentId(feeCollectionDTO.getStudentId())
                .studentName(feeCollectionDTO.getStudentName())
                .schoolName(feeCollectionDTO.getSchoolName())
                .feeAmount(feeCollectionDTO.getFeeAmount())
                .paymentMethod(feeCollectionDTO.getPaymentMethod())
                .academicYear(feeCollectionDTO.getAcademicYear())
                .feeType(feeCollectionDTO.getFeeType())
                .remarks(feeCollectionDTO.getRemarks())
                .build();

        FeeCollection saved = feeCollectionRepository.save(feeCollection);
        return mapToReceiptDTO(saved);
    }

    @Override
    public ReceiptDTO getReceiptByNumber(String receiptNumber) {
        FeeCollection feeCollection = feeCollectionRepository.findByReceiptNumber(receiptNumber)
                .orElseThrow(() -> new RuntimeException("Receipt not found: " + receiptNumber));
        return mapToReceiptDTO(feeCollection);
    }

    @Override
    public List<ReceiptDTO> getReceiptsByStudentId(String studentId) {
        return feeCollectionRepository.findByStudentId(studentId)
                .stream()
                .map(this::mapToReceiptDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReceiptDTO> getReceiptsByAcademicYear(String academicYear) {
        return feeCollectionRepository.findByAcademicYear(academicYear)
                .stream()
                .map(this::mapToReceiptDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReceiptDTO> getAllReceipts() {
        return feeCollectionRepository.findAll()
                .stream()
                .map(this::mapToReceiptDTO)
                .collect(Collectors.toList());
    }

    private ReceiptDTO mapToReceiptDTO(FeeCollection feeCollection) {
        return ReceiptDTO.builder()
                .id(feeCollection.getId())
                .receiptNumber(feeCollection.getReceiptNumber())
                .studentId(feeCollection.getStudentId())
                .studentName(feeCollection.getStudentName())
                .schoolName(feeCollection.getSchoolName())
                .feeAmount(feeCollection.getFeeAmount())
                .paymentMethod(feeCollection.getPaymentMethod())
                .academicYear(feeCollection.getAcademicYear())
                .feeType(feeCollection.getFeeType())
                .remarks(feeCollection.getRemarks())
                .paymentDate(feeCollection.getPaymentDate())
                .build();
    }
}