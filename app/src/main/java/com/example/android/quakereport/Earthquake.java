package com.example.android.quakereport;

import android.util.Log;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class Earthquake {
    private String mMagnitude;
    private String mCity;
    private Date mDate;
    private String mDateString;
    private String mTimeString;
    private String mPrimaryLocation;
    private String mLocationOffset;
    private String mStringMagnitude;
    private String mURL;
    private final DecimalFormat mDecimalFormatter = new DecimalFormat("0.0");
    private final SimpleDateFormat mDateFormatter = new SimpleDateFormat("MMM DD, yyyy");
    private final SimpleDateFormat mTimeFormatter = new SimpleDateFormat("HH:mm z");

    public Earthquake(String magnitude, String city, String date, String URL) {
        mMagnitude = magnitude;
        mCity = city;
        mDate = new Date(Long.parseLong(date));
        mDateString = mDateFormatter.format(mDate);
        mTimeString = mTimeFormatter.format(mDate);
        mURL = URL;
        if(city.contains(" of ")) {
            mLocationOffset = city.substring(0, city.indexOf(" of ") + 4);
            mPrimaryLocation = city.substring(city.indexOf(" of ") + 4);
        }else{
            mLocationOffset="Near the";
            mPrimaryLocation=mCity;
        }
        mStringMagnitude = mDecimalFormatter.format(Double.parseDouble(mMagnitude));
        Log.v("Earthquake:",this.toString());
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getCity() {
        return mCity;
    }

    public String getDate() { return mDateString; }

    public String getTime() { return mTimeString; }

    public String getPrimaryLocation() { return mPrimaryLocation; }

    public String getLocationOffset() { return mLocationOffset; }

    public String getStringMagnitude() { return mStringMagnitude; }

    public String getURL() { return mURL; }

    @Override
    public String toString() {
        return "EarthQuake{" +
                "mMagnitude=" + mMagnitude +
                ", mCity='" + mCity + '\'' +
                ", mDate='" + mDate + '\'' +
                ", mDateString='" + mDateString + '\'' +
                ", mPrimaryLocation='" + mPrimaryLocation + '\'' +
                ", mLocationOffset='" + mLocationOffset + '\'' +
                ", mStringMagnitude='" + mStringMagnitude + '\'' +
                '}';
    }
}
