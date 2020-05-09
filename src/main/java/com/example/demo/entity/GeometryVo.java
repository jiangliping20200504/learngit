package com.example.demo.entity;

public class GeometryVo {

    private String type;
    private double[] coordinates;

    public String getType() {
        return type;
    }

    public GeometryVo(String type, double[] coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public GeometryVo setType(String type) {
        this.type = type;
        return this;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public GeometryVo setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
        return this;
    }
}
