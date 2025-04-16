package com.ChatGroup.exception;

import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException exception, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.NOT_FOUND.value()); // Trang thai HTTP: 404
        response.put("message", exception.getMessage()); // Thong điep loi
        response.put("data", null); // Khong co du lieu
        response.put("path", request.getRequestURI()); // Tra ve duong dan
        response.put("timestamp", LocalDateTime.now().toString()); // Thoi gian xay ra loi

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // Tra ve trang thai HTTP 404
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handlingMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();

        response.put("status", HttpStatus.NOT_FOUND.value()); // Trang thai HTTP: 404
        response.put("message", exception.getFieldError().getDefaultMessage()); // Thong điep loi
        response.put("data", null); // Khong co du lieu
        response.put("path", request.getRequestURI()); // Tra ve duong dan
        response.put("timestamp", LocalDateTime.now().toString()); // Thoi gian xay ra loi

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // Tra ve trang thai HTTP 404
    }
}
