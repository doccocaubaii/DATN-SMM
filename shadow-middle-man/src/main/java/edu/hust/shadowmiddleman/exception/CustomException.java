package edu.hust.shadowmiddleman.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {
    private String message;

    private String code = "400";

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public CustomException(String message, String code) {
        super(message);
        this.message = message;
        this.code = code;
    }

}
