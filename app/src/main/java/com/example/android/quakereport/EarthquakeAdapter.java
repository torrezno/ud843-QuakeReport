package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();

    public EarthquakeAdapter(@NonNull Context context, ArrayList<Earthquake> quakes) {
        super(context, 0, quakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View quakeView = convertView;
        if(quakeView == null){
            quakeView = LayoutInflater.from(getContext()).inflate(
                    R.layout.quake_layout, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        Earthquake currentQuake = getItem(position);

        TextView magnitudeTextView = (TextView) quakeView.findViewById(R.id.magnitude);
        TextView cityTextView = (TextView) quakeView.findViewById(R.id.city);
        TextView dateTextView = (TextView) quakeView.findViewById(R.id.date);

        magnitudeTextView.setText(""+currentQuake.getMagnitude());
        cityTextView.setText(""+currentQuake.getCity());
        dateTextView.setText(""+currentQuake.getDate());

        return quakeView;
    }
}
