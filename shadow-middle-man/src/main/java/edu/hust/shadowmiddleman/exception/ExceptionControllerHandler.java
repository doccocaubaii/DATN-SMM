package edu.hust.shadowmiddleman.exception;


import edu.hust.shadowmiddleman.dto.common.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionControllerHandler {

    @ExceptionHandler(value = {AuthenticationException.class})
    public ResponseEntity<ResponseDTO> handleAuthenticationException(Exception ex) {
        ResponseDTO responseDTO = new ResponseDTO("Đăng nhập thất bại", ex.getMessage(), "401");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDTO);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ResponseDTO> handleAccessDeniedException(AccessDeniedException ex) {
        ResponseDTO responseDTO = new ResponseDTO("Bạn không có quyền truy cập", ex.getMessage(), "403");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responseDTO);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ResponseDTO> handleBindException(BindException ex) {
        List<String> errorList = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .toList();
        ResponseDTO responseDTO = new ResponseDTO(
                errorList.get(0), errorList, "400");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
    }
}