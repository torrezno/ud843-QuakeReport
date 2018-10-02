package com.example.android.quakereport;

class Earthquake {
    double mMagnitude;
    String mCity;
    String mDate;

    public Earthquake(double magnitude, String city, String date) {
        this.mMagnitude = magnitude;
        this.mCity = city;
        this.mDate = date;
    }

    public double getMagnitude() {
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
