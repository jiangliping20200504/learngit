package com.example.demo.entity;

public class FeatureVo {

    private String type = "Feature";
    private PropertieVo properties;
    private GeometryVo geometry;

    public String getType() {
        return type;
    }

    public FeatureVo setType(String type) {
        this.type = type;
        return this;
    }

    public PropertieVo getProperties() {
        return properties;
    }

    public FeatureVo setProperties(PropertieVo properties) {
        this.properties = properties;
        return this;
    }

    public GeometryVo getGeometry() {
        return geometry;
    }

    public FeatureVo setGeometry(GeometryVo geometry) {
        this.geometry = geometry;
        return this;
    }
}
