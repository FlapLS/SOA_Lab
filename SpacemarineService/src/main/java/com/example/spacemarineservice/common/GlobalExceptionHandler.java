package com.example.spacemarineservice.common;


import com.example.spacemarineservice.error.ApplicationException;
import com.example.spacemarineservice.error.model.ApplicationError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(ApplicationException.class)
    public ApplicationError handleApplicationException(ApplicationException ex, HttpServletResponse response) {
        response.setStatus(ex.getError().getStatus().value());
        log.debug("Exception happened {}", ex.getMessage());
        return ex.getError();
    }

}
