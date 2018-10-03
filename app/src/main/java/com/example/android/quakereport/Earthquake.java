package com.example.android.quakereport;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

class Earthquake {
    private String mMagnitude;
    private String mCity;
    private Date mDate;
    private String mDateString;
    private final SimpleDateFormat  mDateFormatter = new SimpleDateFormat("MMM DD, yyyy");

    public Earthquake(String magnitude, String city, String date) {
        mMagnitude = magnitude;
        mCity = city;
        mDate = new Date(Long.parseLong(date));
        mDateString = mDateFormatter.format(mDate);
        Log.v("Earthquake:",this.toString());
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getCity() {
        return mCity;
    }

    public String getDate() { return mDateString; }

    @Override
    public String toString() {
        return "EarthQuake{" +
                "mMagnitude=" + mMagnitude +
                ", mCity='" + mCity + '\'' +
                ", mDate='" + mDate + '\'' +
                ", mDateString='" + mDateString + '\'' +
                '}';
    }
}
