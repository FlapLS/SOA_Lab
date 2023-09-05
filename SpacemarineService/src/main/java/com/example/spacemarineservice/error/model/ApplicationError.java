package com.example.spacemarineservice.error.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor(staticName = "of")
public class ApplicationError {

    private String message;

    private LocalDateTime time;

    private HttpStatus status;

    public ApplicationError(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
        this.time = LocalDateTime.now();
    }

}
