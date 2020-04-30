package com.example.fitnesstracker;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


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

        ImageView image = (ImageView) listitemview.findViewById(R.id.image);
        image.setImageResource(currentExercise.getImageResource());

        //textview to show exercise name
        TextView Exercisenm = (TextView) listitemview.findViewById(R.id.exerciseName);
        Exercisenm.setText(currentExercise.getExerciseName());

        //textview to store set_count
        TextView count = (TextView) listitemview.findViewById(R.id.count);
        count.setText(currentExercise.getCountDone()+" / "+currentExercise.getTotalSets());
        return listitemview;
    }
}
