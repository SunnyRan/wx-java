package com.github.binarywang.demo.wx.mp.entity;

public class DriverInfo {

    private String diverName;
    private String diverPhone;
    private int weight;

    public DriverInfo(String diverName, String diverPhone) {
        this.diverName = diverName;
        this.diverPhone = diverPhone;
    }

    public DriverInfo(String diverName, String diverPhone, int weight) {
        this.diverName = diverName;
        this.diverPhone = diverPhone;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDiverName() {
        return diverName;
    }

    public void setDiverName(String diverName) {
        this.diverName = diverName;
    }

    public String getDiverPhone() {
        return diverPhone;
    }

    public void setDiverPhone(String diverPhone) {
        this.diverPhone = diverPhone;
    }
}
