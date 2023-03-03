package com.soliman.todo.handlers;

import com.soliman.todo.exeptions.EntityNotFoundException;
import com.soliman.todo.exeptions.InvalidEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice // this means that the return type will be automatically JSON
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    // each exception needs to have an error handler

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception,
                                                    WebRequest webRequest) {
        // since we have an error : we log it
        logger.error(exception);
        // we fetch the http status as bad request
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        // we create an errorDto
        final ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCodes())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();
        return new ResponseEntity<>(errorDto, badRequest);
    }


    @ExceptionHandler(EntityNotFoundException.class) // the exception you want to intercept(handle)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception,
                                                    WebRequest webRequest) {
        // since wee have an error : we log it
        logger.error(exception);
        // we fetch the http status as bad request
        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        // we create an errorDto
        final ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCodes())
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorDto, notFound);
    }

}
