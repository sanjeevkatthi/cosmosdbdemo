package com.example.cosmos.cosmosdemo.exception;

import com.example.cosmos.cosmosdemo.vo.Error;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by Nisum on 07-03-2019.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value= { ItemDetailsException.class })
    protected ResponseEntity handleItemDetailsException(ItemDetailsException ex, WebRequest request) {
        Error error = new Error();

        String errorMessage = "There is an issue with the item details service. Please try later";
        error.setMessage("testError");
        error.setDescription(errorMessage);
        return handleExceptionInternal(ex, error,new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
