package com.example.fitnesstracker;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.core.content.ContextCompat;

import java.util.ArrayList;


public class ExerAdapter extends ArrayAdapter<Exercise> {

    //custom adapter
    public ExerAdapter(Activity context, ArrayList<Exercise> exercises) {
        //since we are giving our custom resource(txtview, etc)
        super(context, 0,exercises);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //checking if existing view is being used, else inflating
        View listitemview = convertView;
        if (listitemview == null) {
            listitemview = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_layout, parent, false);
        }

        Exercise currentExercise = getItem(position);

        ImageView image = listitemview.findViewById(R.id.image);
        image.setImageResource(currentExercise.getImageResource());

        //textview to show exercise name
        TextView Exercisenm = listitemview.findViewById(R.id.exerciseName);
        Exercisenm.setText(currentExercise.getExerciseName());

        //Initialising textview to store set_count
        TextView count = listitemview.findViewById(R.id.count);

        if (currentExercise.getCountDone().compareTo(currentExercise.getTotalSets()) != 0)
            count.setText(currentExercise.getCountDone() + " / " + currentExercise.getTotalSets());

        else {
            count.setText("DONE");
        }

        //Initializing the theme color for the list item
        View textContainer = listitemview.findViewById(R.id.EachElement);
        //getting the background colour for the current onj
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), currentExercise.getBackGroundColour());
        textContainer.setBackgroundColor(color);

        //returning the data for displaying list item
        return listitemview;
    }
}
