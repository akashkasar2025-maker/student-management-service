package com.studentmgmt.controller;

import com.studentmgmt.dto.ApiResponse;
import com.studentmgmt.dto.FeeCollectionDTO;
import com.studentmgmt.dto.ReceiptDTO;
import com.studentmgmt.service.FeeCollectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fee-collection")
@Tag(name = "Fee Collection", description = "APIs for fee collection and receipt management")
public class FeeCollectionController {

    private final FeeCollectionService feeCollectionService;

    // Explicit constructor – replaces @RequiredArgsConstructor
    public FeeCollectionController(FeeCollectionService feeCollectionService) {
        this.feeCollectionService = feeCollectionService;
    }

    @PostMapping("/collect")
    @Operation(summary = "Collect fee from student", description = "Record fee collection and generate receipt")
    public ResponseEntity<ApiResponse<ReceiptDTO>> collectFee(
            @RequestBody FeeCollectionDTO feeCollectionDTO) {
        ReceiptDTO receipt = feeCollectionService.collectFee(feeCollectionDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Fee collected successfully, receipt generated", receipt));
    }

    @GetMapping("/receipt/{receiptNumber}")
    @Operation(summary = "Get receipt by number", description = "Retrieve receipt details")
    public ResponseEntity<ApiResponse<ReceiptDTO>> getReceipt(
            @Parameter(description = "Receipt number") @PathVariable String receiptNumber) {
        ReceiptDTO receipt = feeCollectionService.getReceiptByNumber(receiptNumber);
        return ResponseEntity.ok(ApiResponse.success("Receipt retrieved successfully", receipt));
    }

    @GetMapping("/receipts/student/{studentId}")
    @Operation(summary = "Get receipts by student ID", description = "Retrieve all receipts for a student")
    public ResponseEntity<ApiResponse<List<ReceiptDTO>>> getReceiptsByStudent(
            @Parameter(description = "Student ID") @PathVariable String studentId) {
        List<ReceiptDTO> receipts = feeCollectionService.getReceiptsByStudentId(studentId);
        return ResponseEntity.ok(ApiResponse.success("Receipts retrieved successfully", receipts));
    }

    @GetMapping("/receipts/year/{academicYear}")
    @Operation(summary = "Get receipts by academic year", description = "Retrieve receipts for a specific academic year")
    public ResponseEntity<ApiResponse<List<ReceiptDTO>>> getReceiptsByAcademicYear(
            @Parameter(description = "Academic year") @PathVariable String academicYear) {
        List<ReceiptDTO> receipts = feeCollectionService.getReceiptsByAcademicYear(academicYear);
        return ResponseEntity.ok(ApiResponse.success("Receipts retrieved successfully", receipts));
    }

    @GetMapping("/receipts")
    @Operation(summary = "Get all receipts", description = "Retrieve all fee collection receipts")
    public ResponseEntity<ApiResponse<List<ReceiptDTO>>> getAllReceipts() {
        List<ReceiptDTO> receipts = feeCollectionService.getAllReceipts();
        return ResponseEntity.ok(ApiResponse.success("Receipts retrieved successfully", receipts));
    }

    @GetMapping("/health")
    @Operation(summary = "Health check", description = "Check if service is running")
    public ResponseEntity<ApiResponse<String>> health() {
        return ResponseEntity.ok(ApiResponse.success("Service is running", "OK"));
    }
}