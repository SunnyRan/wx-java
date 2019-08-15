package com.github.binarywang.demo.wx.mp.entity;

import java.sql.Timestamp;

public class MessageInfo {

    private String userId;
    private String senderName;
    private String senderAddress;
    private String senderPhone;
    private String receptName;
    private String receptAddress;
    private String receptPhone;
    private String goodsType;
    private String expectedDeliveryTime;
    private String gratuity;
    private Timestamp timestamp;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getReceptName() {
        return receptName;
    }

    public void setReceptName(String receptName) {
        this.receptName = receptName;
    }

    public String getReceptAddress() {
        return receptAddress;
    }

    public void setReceptAddress(String receptAddress) {
        this.receptAddress = receptAddress;
    }

    public String getReceptPhone() {
        return receptPhone;
    }

    public void setReceptPhone(String receptPhone) {
        this.receptPhone = receptPhone;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }

    public void setExpectedDeliveryTime(String expectedDeliveryTime) {
        this.expectedDeliveryTime = expectedDeliveryTime;
    }

    public String getGratuity() {
        return gratuity;
    }

    public void setGratuity(String gratuity) {
        this.gratuity = gratuity;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
