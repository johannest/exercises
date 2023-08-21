package com.vaadin.training.framework.exercises.ex8;

import java.util.Date;

public class Product {

    private String name;
    private double price;
    private Date available;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getAvailable() {
        return available;
    }

    public void setAvailable(Date available) {
        this.available = available;
    }
}
