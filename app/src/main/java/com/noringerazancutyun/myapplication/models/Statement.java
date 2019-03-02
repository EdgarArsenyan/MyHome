package com.noringerazancutyun.myapplication.models;

public class Statement {
    private String category;
    private String type;
    private String price;
    private String rooms;
    private String floor;
    private String district;
    private String address;
    private String desc;
    private int image;


    public Statement(String price, String district,String rooms, String floor) {

        this.price = price;
        this.rooms = rooms;
        this.floor = floor;
        this.district = district;
    }

    public String getDistrict() {
        return district;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setDistrics(String district) {
        this.district = district;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String prive) {
        this.price = prive;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
