package fpt.backend.taskManagement.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptHandler {

    @ExceptionHandler({TaskNotFoundException.class, UserNotFoundException.class})
    public ResponseEntity<ExceptionResponse> handleTaskNotFoundExcept(Exception e){
        return ResponseEntity.badRequest().body(new ExceptionResponse("Failed",e.getMessage()));
    }
}
