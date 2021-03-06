package com.trzewik.budgettrackerserver.adapter;

import com.trzewik.budgettrackerserver.domain.ToLowPriceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Agnieszka Trzewik
 */
@ControllerAdvice
class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ToLowPriceException.class)
    protected void handleBadRequest(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
