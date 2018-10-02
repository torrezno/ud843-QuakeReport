package com.example.android.quakereport;

class Earthquake {
    String mMagnitude;
    String mCity;
    String mDate;

    public Earthquake(String magnitude, String city, String date) {
        this.mMagnitude = magnitude;
        this.mCity = city;
        this.mDate = date;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getCity() {
        return mCity;
    }

    public String getDate() {
        return mDate;
    }

    @Override
    public String toString() {
        return "EarthQuake{" +
                "mMagnitude=" + mMagnitude +
                ", mCity='" + mCity + '\'' +
                ", mDate='" + mDate + '\'' +
                '}';
    }
}
