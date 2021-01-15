package com.example.fnbordering.Model;

public class Category {
    private String Name;
    private String Image;
    private String Location;
    private String Range;

    public Category() {
    }

    public Category(String name, String image, String location, String range) {
        Name = name;
        Image = image;
        Location = location;
        Range = range;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getRange() {
        return Range;
    }

    public void setRange(String range) {
        Range = range;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
