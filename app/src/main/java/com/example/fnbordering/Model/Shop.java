package com.example.fnbordering.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.nio.charset.Charset;

public class Shop implements Parcelable {
    private String name, location, range, keyId;

    public Shop() {
    }

    public Shop(String name, String location, String range) {
        this.name = name;
        this.location = location;
        this.range = range;
    }

    protected Shop(Parcel in) {
        name = in.readString();
        location = in.readString();
        range = in.readString();
        keyId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(location);
        dest.writeString(range);
        dest.writeString(keyId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Shop> CREATOR = new Creator<Shop>() {
        @Override
        public Shop createFromParcel(Parcel in) {
            return new Shop(in);
        }

        @Override
        public Shop[] newArray(int size) {
            return new Shop[size];
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

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }
}
