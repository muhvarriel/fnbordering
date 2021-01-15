package com.example.fnbordering.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {
    private String name, price, id, desc;

    public Food() {
    }

    public Food(String name, String price, String id, String desc) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.desc = desc;
    }

    protected Food(Parcel in) {
        name = in.readString();
        price = in.readString();
        id = in.readString();
        desc = in.readString();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(price);
        dest.writeString(id);
        dest.writeString(desc);
    }
}
