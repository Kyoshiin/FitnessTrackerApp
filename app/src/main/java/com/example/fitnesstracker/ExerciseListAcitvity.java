package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExerciseListAcitvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_list);

        Intent intent = getIntent();
        int set_count = intent.getIntExtra("count_sets",0);
        Toast.makeText(getApplicationContext(),"WELCOME to the tracking area..",Toast.LENGTH_LONG).show();

        final ArrayList<Exercise> exs = new ArrayList<Exercise>();
        exs.add(new Exercise("Push-ups", set_count, 0, R.drawable.pushup_img, R.color.Incomplete_task));
        exs.add(new Exercise("Crunches", set_count, 0, R.drawable.crunches, R.color.Incomplete_task));
        exs.add(new Exercise("Burpees", set_count, 0, R.drawable.burpees, R.color.Incomplete_task));
        exs.add(new Exercise("High Knees", set_count, 0, R.drawable.highknee, R.color.Incomplete_task));
        exs.add(new Exercise("Jumping Jacks", set_count, 0, R.drawable.jumpingjacks, R.color.Incomplete_task));
        exs.add(new Exercise("Leg Raise", set_count, 0, R.drawable.legraise, R.color.Incomplete_task));
        exs.add(new Exercise("Lunges", set_count, 0, R.drawable.lunge, R.color.Incomplete_task));
        exs.add(new Exercise("Plank", set_count, 0, R.drawable.plank, R.color.Incomplete_task));
        exs.add(new Exercise("Power Plank", set_count, 0, R.drawable.powerplank, R.color.Incomplete_task));
        exs.add(new Exercise("Russian Twist", set_count, 0, R.drawable.russiantwist, R.color.Incomplete_task));
        exs.add(new Exercise("Side Plank", set_count, 0, R.drawable.sideplank, R.color.Incomplete_task));
        exs.add(new Exercise("Squats", set_count, 0, R.drawable.squats, R.color.Incomplete_task));
        exs.add(new Exercise("Superman", set_count, 0, R.drawable.superman, R.color.Incomplete_task));
        exs.add(new Exercise("Wall Sit", set_count, 0, R.drawable.wallsit, R.color.Incomplete_task));


        ExerAdapter itemAdapter = new ExerAdapter(this,exs);
        ListView listview = findViewById(R.id.list);
        listview.setAdapter(itemAdapter);

        //on clicking on list item
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //object to increase completed sets
                //getting the exercise object at that position in the arraylist
                Exercise obj = exs.get(position);
                obj.IncreaseCountDone();

                //textview to store set_count
                TextView count = view.findViewById(R.id.count);
                // checking if no. of sets_done equal to Total no. of sets
                if (obj.getCountDone().compareTo(obj.getTotalSets())!=0)
                    count.setText(obj.getCountDone()+" / "+obj.getTotalSets());

                else {
                    count.setText("DONE");
                    //setting done background clr
                    obj.setBackGroundColour();
                    Toast.makeText(getApplicationContext(),"Well Done!!",Toast.LENGTH_SHORT).show();
                }

                // Set the theme color for the list item when done
                View textContainer = view.findViewById(R.id.EachElement);
                //getting the background colour for the current obj
                // Find the color that the resource ID maps to
                int color = ContextCompat.getColor(getApplicationContext(), obj.getBackGroundColour());
                textContainer.setBackgroundColor(color);
            }
        });
    }
}
