package com.wzt.practise.controller;

import com.wzt.practise.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Hello {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/")
    public String submit(){
        log.info("start submit");

        //调用service层的任务
        asyncService.executeAsync();

        log.info("end submit");

        return "success";
    }
}