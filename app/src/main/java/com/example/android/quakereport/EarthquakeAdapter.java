package com.example.android.quakereport;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
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
        final Earthquake currentQuake = getItem(position);

        TextView magnitudeTextView = (TextView) quakeView.findViewById(R.id.magnitude);
        TextView locationOffsetTextView = (TextView) quakeView.findViewById(R.id.location_offset);
        TextView primaryLocationTextView = (TextView) quakeView.findViewById(R.id.primary_location);
        TextView dateTextView = (TextView) quakeView.findViewById(R.id.date);
        TextView timeTextView = (TextView) quakeView.findViewById(R.id.time);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();


        assert currentQuake != null;
        int magnitudeColor = getMagnitudeColor(currentQuake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);
        magnitudeTextView.setText(currentQuake.getStringMagnitude());
        locationOffsetTextView.setText(currentQuake.getLocationOffset());
        primaryLocationTextView.setText(currentQuake.getPrimaryLocation());
        dateTextView.setText(currentQuake.getDate());
        timeTextView.setText(currentQuake.getTime());



        return quakeView;
    }

    private int getMagnitudeColor(String magnitude) {

        int mag = (int) Math.floor(Double.parseDouble(magnitude));
        Log.v("GET MAGNITUDE:","MagnitudeString: " + magnitude +
                                            "\n MagnitudeInt: " + mag);
        int color;
        switch (mag){
            case 0:
            case 1:
                color = ContextCompat.getColor(getContext(),R.color.magnitude1);
                break;
            case 2:
                color = ContextCompat.getColor(getContext(),R.color.magnitude2);
                break;
            case 3:
                color = ContextCompat.getColor(getContext(),R.color.magnitude3);
                break;
            case 4:
                color = ContextCompat.getColor(getContext(),R.color.magnitude4);
                break;
            case 5:
                color = ContextCompat.getColor(getContext(),R.color.magnitude5);
                break;
            case 6:
                color = ContextCompat.getColor(getContext(),R.color.magnitude6);
                break;
            case 7:
                color = ContextCompat.getColor(getContext(),R.color.magnitude7);
                break;
            case 8:
                color = ContextCompat.getColor(getContext(),R.color.magnitude8);
                break;
            case 9:
                color = ContextCompat.getColor(getContext(),R.color.magnitude9);
                break;
            default:
                color = ContextCompat.getColor(getContext(),R.color.magnitude10plus);
                break;
        }
        Log.v("GET MAGNITUDE:","MagnitudeString: " + magnitude +
                "\n MagnitudeInt: " + mag +
                "\n COLOR: " + color);
        return color;
    }


}
