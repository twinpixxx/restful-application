package com.labs.restservice.exception.InternalException;
import com.labs.restservice.calculations.CalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class InternalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(CalculationService.class);


    @ExceptionHandler(value = {ArithmeticException.class})
    public ResponseEntity<Object> handleArithmeticException(InternalArithmeticException e) {
        log.error(String.format("Error Code: %s\n" +
                                "Error Message: %s", e.getExceptionCode(), e.getMessage()), e);
        InternalException arithmeticException = new InternalException(e.getExceptionCode(),
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now());
        return new ResponseEntity<>(arithmeticException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
