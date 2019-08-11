package com.github.binarywang.demo.wx.mp.model;

import lombok.Data;

import java.io.PipedReader;

/**
 * @program: weixin-java-mp-demo-springboot
 * @description:
 * @author: Arnold
 * @create: 2019-08-11 15:24
 **/

@Data
public class TemplateMessageData {
    private String name;
    private String value;
    private String color;
}
