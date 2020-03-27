package com.labs.restservice.exception.ApiException;

import com.labs.restservice.calculations.CalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;


@ControllerAdvice
public class ApiExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(CalculationService.class);


    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        log.error(e.getMessage(), e);
        ApiException apiException = new ApiException(e.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ MissingServletRequestParameterException.class })
    public ResponseEntity<Object> handleMissingParams(MissingServletRequestParameterException e) {
        String missingParamName = String.format("Missing the %s param", e.getParameterName());
        log.error(missingParamName, e);
        ApiException apiException = new ApiException(missingParamName,
                HttpStatus.UNPROCESSABLE_ENTITY,
                LocalDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleApiRequestArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        String errorMessage = String.format("Variables should be type of %s", e.getRequiredType().getName());
        log.error(errorMessage, e);
        ApiException apiException = new ApiException(errorMessage,
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

}
