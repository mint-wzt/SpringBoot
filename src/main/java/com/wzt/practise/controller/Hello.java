package com.wzt.practise.controller;

import com.wzt.practise.service.AsyncService;
import com.wzt.practise.service.ExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/test")
public class Hello {

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private ExcelService excelService;

    @PostMapping("/hello")
    public String submit(){
        log.info("start submit");
        //调用service层的任务
        asyncService.executeAsync();
        log.info("end submit");
        return "success";
    }

    @PostMapping("/simple")
    public String writeExcel() throws IOException {
        return excelService.writeExcel();
    }

    @PostMapping("/dynamic1")
    public String writeExcel2() throws IOException {
        return excelService.writeExcel2();
    }

}