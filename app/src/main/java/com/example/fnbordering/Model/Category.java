package com.example.fnbordering.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.nio.charset.Charset;

public class Category implements Parcelable {
    private String name, location, range, categoryId;

    public Category() {
    }

    public Category(String name, String location, String range) {
        this.name = name;
        this.location = location;
        this.range = range;
    }

    protected Category(Parcel in) {
        name = in.readString();
        location = in.readString();
        range = in.readString();
        categoryId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(location);
        dest.writeString(range);
        dest.writeString(categoryId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
