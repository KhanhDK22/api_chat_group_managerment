package com.ChatGroup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException exception) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.NOT_FOUND.value()); // Trạng thái HTTP: 404
        response.put("message", exception.getMessage()); // Thông điệp lỗi
        response.put("data", null); // Không có dữ liệu
        response.put("timestamp", LocalDateTime.now().toString()); // Thời gian xảy ra lỗi

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // Trả về trạng thái HTTP 404
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handlingMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, Object> response = new HashMap<>();

        response.put("status", HttpStatus.NOT_FOUND.value()); // Trạng thái HTTP: 404
        response.put("message", exception.getFieldError().getDefaultMessage()); // Thông điệp lỗi
        response.put("data", null); // Không có dữ liệu
        response.put("timestamp", LocalDateTime.now().toString()); // Thời gian xảy ra lỗi

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
