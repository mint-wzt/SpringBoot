package com.wzt.springboot.springboot.web;

import com.wzt.springboot.springboot.exception.ResourseNotFoundException;
import com.wzt.springboot.springboot.exception.ResourseNotFoundException2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class ResponseStatusExceptionController {
    @GetMapping("/resourceNotFoundException2")
    public void throwException() {
        throw new ResourseNotFoundException2("Sorry, the resourse not found!");
    }

    @GetMapping("/resourceNotFoundException3")
    public void throwException1() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, the resourse not found!", new ResourseNotFoundException());
    }
}
