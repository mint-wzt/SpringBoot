package com.wzt.springboot.springboot.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Msg {
    private String title;
    private String content;
    private String etraInfo;
}
