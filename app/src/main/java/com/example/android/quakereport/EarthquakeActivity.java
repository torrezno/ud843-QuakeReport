/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.app.LoaderManager.LoaderCallbacks;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

//https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-01-31&minmag=6&limit=10
public class EarthquakeActivity extends AppCompatActivity
        implements LoaderCallbacks<List<Earthquake>> {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    private static final int EARTHQUAKE_LOADER_ID = 1;
    private static final String URL_STRING = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";

    private EarthquakeAdapter mAdapter;
    private TextView mEmptyStateTextView;
    private ProgressBar mLoaderIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(LOG_TAG,"TESTLOADER - MainActivity onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        ListView earthquakeListView = (ListView) findViewById(R.id.list_view);
        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        earthquakeListView.setEmptyView(mEmptyStateTextView);
        mLoaderIndicator = (ProgressBar) findViewById(R.id.loading_spinner);


        mAdapter = new EarthquakeAdapter(this, new ArrayList<Earthquake>());

        earthquakeListView.setAdapter(mAdapter);
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Earthquake currentEarthquake = mAdapter.getItem(i);
                Uri quakeUri = Uri.parse(currentEarthquake.getURL());
                Intent webIntent = new Intent(Intent.ACTION_VIEW, quakeUri);
                startActivity(webIntent);
            }
        });



        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()) {
            Log.v(LOG_TAG, "TESTLOADER - In main Activity, ask for a loaderManager");
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);
        }else{
            mLoaderIndicator.setVisibility(View.GONE);
            mEmptyStateTextView.setText("No internet connection");
        }

    }


    @Override
    public android.content.Loader<List<Earthquake>> onCreateLoader(int i, Bundle bundle) {
        Log.v(LOG_TAG,"TESTLOADER - in onCreateLoader method, creating a new Loader cause it didnt found it");
        return new EarthquakeLoader(this, URL_STRING);
    }

    @Override
    public void onLoadFinished(android.content.Loader<List<Earthquake>> loader, List<Earthquake> earthquakes) {
        Log.v(LOG_TAG,"TESTLOADER - Finished loading data, lets plug the new data onto the adapter");
        mLoaderIndicator.setVisibility(View.GONE);
        mAdapter.clear();
        if(earthquakes!=null && !earthquakes.isEmpty()){
            mAdapter.addAll(earthquakes);
        }
        mEmptyStateTextView.setText("No earthquakes found");
    }

    @Override
    public void onLoaderReset(android.content.Loader<List<Earthquake>> loader) {
        Log.v(LOG_TAG,"TESTLOADER - Loader has been reset.");
         mAdapter.clear();
    }
}
