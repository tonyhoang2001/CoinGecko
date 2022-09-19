package com.example.testcoin;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({IllegalArgumentException.class,
                                                                ArithmeticException.class,
                                                                ArrayIndexOutOfBoundsException.class,
                                                                NumberFormatException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage invalidPageable(Exception e, WebRequest request){
        //page size, page num wrong format
        return new ErrorMessage(500,"Page size and page number must be a positive integer!");
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage invalidPageNum(Exception e, WebRequest request){
        // page num > num of page
        return new ErrorMessage(500,"Page number cannot be greater than the number of page!");
    }

}
