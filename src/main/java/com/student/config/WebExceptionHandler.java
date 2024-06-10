package com.student.config;

import com.student.common.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler
    public R<Void> exceptionHandler(Exception e) {
        e.printStackTrace();
        return R.error(e.getMessage());
    }

}
