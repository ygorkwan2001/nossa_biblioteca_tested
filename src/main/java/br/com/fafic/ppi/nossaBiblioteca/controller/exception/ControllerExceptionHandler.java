package br.com.fafic.ppi.nossaBiblioteca.controller.exception;

import br.com.fafic.ppi.nossaBiblioteca.Exception.DefaultException;
import br.com.fafic.ppi.nossaBiblioteca.domain.exception.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<DefaultException> objectNotFoundException(ObjectNotFoundException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(DefaultException.builder()
                .error("Objeto Nao econtrado")
                .messagem(ex.getMessage())
                .path(request.getRequestURI())
                .status(HttpStatus.NO_CONTENT.value())
                .timestamp(LocalDateTime.now())
                .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultException> handleValidationException(MethodArgumentNotValidException ex,HttpServletRequest request) {
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        String errorMessage = "";
        for (ObjectError error : errors) {
            errorMessage += error.getDefaultMessage() + "\n";
        }
        return ResponseEntity.status(HttpStatus.OK).body(DefaultException.builder()
                .status(HttpStatus.NO_CONTENT.value())
                .error("erro de sintaxe")
                .messagem(errorMessage)
                .path(request.getRequestURI())
                .status(HttpStatus.NO_CONTENT.value())
                .timestamp(LocalDateTime.now()).build());
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<DefaultException> handleException(Exception ex,HttpServletRequest request) {
//        return ResponseEntity.status(HttpStatus.OK).body(DefaultException.builder()
//                .status(HttpStatus.NO_CONTENT.value())
//                .error("erro de parametro")
//                .messagem(ex.getMessage())
//                .path(request.getRequestURI())
//                .status(HttpStatus.NO_CONTENT.value())
//                .timestamp(LocalDateTime.now()).build());
//    }
}
