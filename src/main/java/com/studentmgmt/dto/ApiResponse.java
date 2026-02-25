package com.studentmgmt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.Instant;

@Schema(description = "Generic API Response")
public class ApiResponse<T> {

    @JsonProperty("status")
    @Schema(description = "Response status", example = "success")
    private final String status;

    @JsonProperty("message")
    @Schema(description = "Response message", example = "Operation successful")
    private final String message;

    @JsonProperty("data")
    @Schema(description = "Response data")
    private final T data;

    @JsonProperty("timestamp")
    @Schema(description = "Response timestamp", example = "1677123456789")
    private final Long timestamp;

    // Private constructor – used only via static factory methods
    private ApiResponse(String status, String message, T data, Long timestamp) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(
                "success",
                message,
                data,
                Instant.now().toEpochMilli()
        );
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(
                "error",
                message,
                null,
                Instant.now().toEpochMilli()
        );
    }

    // Getters (manually added – replaces @Data)
    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}