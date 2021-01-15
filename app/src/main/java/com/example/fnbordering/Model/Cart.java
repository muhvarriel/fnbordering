package com.example.fnbordering.Model;

public class Cart {
    private String ProductId, ProductName, Quantity, Price, User;

    public Cart() {
    }

    public Cart(String productId, String productName, String quantity, String price, String user) {
        ProductId = productId;
        ProductName = productName;
        Quantity = quantity;
        Price = price;
        User = user;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }
}
