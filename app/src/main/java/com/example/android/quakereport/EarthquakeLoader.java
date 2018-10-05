package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** Query URL */
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl=url;
        Log.v(LOG_TAG,"TESTLOADER - In constructor of EarhquakeLoader. URL = " +url);
    }

    @Override
    protected void onStartLoading() {
        Log.v(LOG_TAG,"TESTLOADER - In onStartLoading of EarhquakeLoader.");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.v(LOG_TAG,"TESTLOADER - This is the background thread.");
        List<Earthquake> quakes = null;

        if(mUrl==null){
            return quakes;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        quakes = QueryUtils.fetchEarthquakeData(mUrl);

        return quakes;
    }
}
