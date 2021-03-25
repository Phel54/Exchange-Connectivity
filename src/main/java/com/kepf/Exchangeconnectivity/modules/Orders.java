package com.kepf.Exchangeconnectivity.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Orders {
    private int id;
    private String side;
    private double price;
    private int quantity;
    private String product;

    public Orders() {
    }

    public Orders(int id, String side, double price, int quantity, String product) {
        this.id = id;
        this.side = side;
        this.price = price;
        this.quantity = quantity;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "com.kepf.Exchangeconnectivity.modules.Orders{" +
                "id=" + id +
                ", side='" + side + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", product='" + product + '\'' +
                '}';
    }
}
