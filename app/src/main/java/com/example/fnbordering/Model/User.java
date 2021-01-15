package com.example.fnbordering.Model;

public class User {
    private String Name;
    private String Password;
    private int Balance;
    private String Location;

    public User() {
    }

    public User(String name, String password, int balance, String location) {
        Name = name;
        Password = password;
        Balance = balance;
        Location = location;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
