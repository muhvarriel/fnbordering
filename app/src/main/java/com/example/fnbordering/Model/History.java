package com.example.fnbordering.Model;
import com.example.fnbordering.Model.Cart;

public class History {
    private String ProductId, ProductName, Quantity, Price, User;

    public History() {
    }

    public History(String productId, String productName, String quantity, String price, String user) {
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
