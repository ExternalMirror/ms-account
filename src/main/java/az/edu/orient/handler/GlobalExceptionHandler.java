package az.edu.orient.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<FieldException> fieldExceptions  = exception.getFieldErrors().stream()
                .map(f-> FieldException.builder().fieldName(f.getField()).errorMessage(f.getDefaultMessage()).build())
                .toList();
        var result = ExceptionResponse.builder()
                //this is placeholder, but you need to define which exception you will have and put code for that
                //in normal, this is meaningless
                .code(HttpStatus.BAD_REQUEST.value())
                //this show what message we put on request
                .message(HttpStatus.BAD_REQUEST.toString())
                .fieldErrors(fieldExceptions)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleAccountNotFoundException(AccountNotFoundException exception){
        var result = ExceptionResponse.builder().code(HttpStatus.NOT_FOUND.value()).message(exception.getMessage()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }
}
