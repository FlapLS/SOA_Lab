package com.example.spacemarineservice.error;

import com.example.spacemarineservice.error.model.ApplicationError;
import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
    private final ApplicationError error;

    public ApplicationException(ApplicationError error) {
        super(error.getMessage());
        this.error = error;
    }

    public ApplicationException(ApplicationError error, Throwable throwable) {
        super(error.getMessage(), throwable);
        this.error = error;
    }

}
