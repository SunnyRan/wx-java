package com.github.binarywang.demo.wx.mp.service;

import com.github.binarywang.demo.wx.mp.entity.MessageInfo;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SendMessageService {

    private final Cache<String, MessageInfo> orderCache = CacheBuilder.newBuilder()
        .expireAfterWrite(300, TimeUnit.SECONDS).build();

    public void addOrderInfo(String userId, String senderName, String senderAddress, String senderPhone,
                             String receptName, String receptAddress, String receptPhone) {

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setUserId(userId);
        messageInfo.setSenderName(senderName);
        messageInfo.setSenderAddress(senderAddress);
        messageInfo.setSenderPhone(senderPhone);
        messageInfo.setReceptName(receptName);
        messageInfo.setReceptAddress(receptAddress);
        messageInfo.setReceptPhone(receptPhone);
        messageInfo.setExpectedDeliveryTime("2019-08-16 12:00:00");
        messageInfo.setGoodsType("文件");
        messageInfo.setGratuity("5.0");

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        messageInfo.setTimestamp(timestamp);

        orderCache.put(userId, messageInfo);

    }

    public MessageInfo getOrderInfo(String userId) {

        MessageInfo messageInfo = orderCache.getIfPresent(userId);

        if (null != messageInfo){

            return messageInfo;
        }

        return new MessageInfo();

    }

}
