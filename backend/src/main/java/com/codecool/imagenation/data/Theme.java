package com.codecool.imagenation.data;

public class Theme {

    private String color = "#03071e";
    private int size = 200;
    private String borderColor = "#0077b6";
    private Float borderWidth = 0f;
    private String object = "dot-circle";
    private String objectFile = "fontawesome/solid/dot-circle.svg";

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

    public void setObject(String object) {
        this.object = object;
    }

    public void setObjectFile(String objectFile) {
        this.objectFile = objectFile;
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

    public String getObject() {
        return object;
    }

    public String getObjectFile() {
        return objectFile;
    }
}
