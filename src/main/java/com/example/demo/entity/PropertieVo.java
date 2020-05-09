package com.example.demo.entity;

public class PropertieVo {
    private int id;
    private String name;
    private String phone = "";
    private String description = "";

    public int getId() {
        return id;
    }

    public PropertieVo(int id, String name, String phone, String description) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.description = description;
    }

    public PropertieVo setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PropertieVo setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public PropertieVo setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PropertieVo setDescription(String description) {
        this.description = description;
        return this;
    }
}
