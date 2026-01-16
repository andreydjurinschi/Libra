package org.cedacri.spring.cedintlibra.controller.exception.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNoSuchElementException(Model model, NoSuchElementException e){
        model.addAttribute(e.getMessage());
        return "errors/404";
    }
}
