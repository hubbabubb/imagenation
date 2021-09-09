package com.codecool.imagenation.logic;

import java.util.Map;


public class Theme {

    private String color = "#03071e";
    private int size = 350;
    private String borderColor = "#0077b6";
    private Float borderWidth = 0f;
    private Map<String, String> allObjects;
    private String object;
    private String objectFile;

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void setBorderWidth(Float borderWidth) {
        this.borderWidth = borderWidth;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public Float getBorderWidth() {
        return borderWidth;
    }

    public Map<String, String> getAllObjects() {
        return allObjects;
    }

    public void setAllObjects(Map<String, String> allObjects) {
        this.allObjects = allObjects;
    }

    public String getObjectFile() {
        return objectFile;
    }

    public void setObjectFile(String objectFile) {
        this.objectFile = objectFile;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
