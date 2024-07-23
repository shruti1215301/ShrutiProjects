package com.nagarro.training;

public class dataModel {
    private String id;
    private String modelName;
    private String color;
    private String gender;
    private String size;
    private double price;
    private double rating;
    private char availability;

    public dataModel(String id, String modelName, String color, String gender, String size, double price, double rating, char availability) {
        this.id = id;
        this.modelName = modelName;
        this.color = color;
        this.gender = gender;
        this.size = size;
        this.price = price;
        this.rating = rating;
        this.availability = availability;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public char getAvailability() {
        return availability;
    }

    public void setAvailability(char availability) {
        this.availability = availability;
    }
}
