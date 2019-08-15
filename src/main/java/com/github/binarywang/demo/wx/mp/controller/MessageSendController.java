package com.github.binarywang.demo.wx.mp.controller;

import com.github.binarywang.demo.wx.mp.service.SendMessageService;
import com.github.binarywang.demo.wx.mp.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageSendController {

    @Autowired
    SendMessageService sendMessageService;

    @RequestMapping(value = "/add/send/info", method = RequestMethod.POST)
    public ApiResponse addOrderInfo(@RequestParam String userId,
                                    @RequestParam String senderName,
                                    @RequestParam String senderAddress,
                                    @RequestParam String senderPhone,
                                    @RequestParam String receptName,
                                    @RequestParam String receptAddress,
                                    @RequestParam String receptPhone) {
        sendMessageService.addOrderInfo(userId, senderName, senderAddress, senderPhone, receptName, receptAddress, receptPhone);
        return ApiResponse.success();
    }

    @RequestMapping(value = "/get/msg", method = RequestMethod.GET)
    public ApiResponse getOrderInfo(@RequestParam String userId) {
        sendMessageService.getOrderInfo(userId);
        return ApiResponse.success();
    }



}
