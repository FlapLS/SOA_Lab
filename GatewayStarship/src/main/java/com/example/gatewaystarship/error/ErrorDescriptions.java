package com.example.gatewaystarship.error;

import com.example.gatewaystarship.error.model.ApplicationError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorDescriptions {

    INVALID_PARAMETERS("001", "Невалидные данные", HttpStatus.BAD_REQUEST),
    NOT_FOUND("002", "Элемент не найден", HttpStatus.NOT_FOUND),
    INCORRECT_PAGE_REQUEST("003", "Неверный Page запрос", HttpStatus.BAD_REQUEST),
    HANDLER_NOT_FOUND("004", "HANDLER_NOT_FOUND", HttpStatus.NOT_FOUND);

    private final String code;

    private final String message;

    private final HttpStatus status;

    public void throwException() throws ApplicationException {
        throw exception();
    }

    public void throwIfNull(Object obj) {
        if (obj == null) {
            throw exception();
        }
    }

    public void throwIfTrue(Boolean condition) {
        if (condition) {
            throw exception();
        }
    }

    public void throwIfFalse(Boolean condition) {
        if (!condition) {
            throw exception();
        }
    }

    public ApplicationError applicationError() {
        return new ApplicationError(this.message, this.status);
    }


    public ApplicationException exception() {
        return new ApplicationException(applicationError());
    }
}
