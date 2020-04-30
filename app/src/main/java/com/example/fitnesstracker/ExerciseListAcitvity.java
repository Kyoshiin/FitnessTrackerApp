package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
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
        exs.add(new Exercise("Push-ups",set_count,0,R.drawable.pushup_img));
        exs.add(new Exercise("Crunches",set_count,0,R.drawable.crunches));
        exs.add(new Exercise("Burpees",set_count,0,R.drawable.burpees));
        exs.add(new Exercise("High Knees",set_count,0,R.drawable.highknee));
        exs.add(new Exercise("Jumping Jacks",set_count,0,R.drawable.jumpingjacks));
        exs.add(new Exercise("Leg Raise",set_count,0,R.drawable.legraise));
        exs.add(new Exercise("Lunges",set_count,0,R.drawable.lunge));
        exs.add(new Exercise("Plank",set_count,0,R.drawable.plank));
        exs.add(new Exercise("Power Plank",set_count,0,R.drawable.powerplank));
        exs.add(new Exercise("Russian Twist",set_count,0,R.drawable.russiantwist));
        exs.add(new Exercise("Side Plank",set_count,0,R.drawable.sideplank));
        exs.add(new Exercise("Squats",set_count,0,R.drawable.squats));
        exs.add(new Exercise("Superman",set_count,0,R.drawable.superman));
        exs.add(new Exercise("Wall Sit",set_count,0,R.drawable.wallsit));


        ExerAdapter itemAdapter = new ExerAdapter(this,exs);
        ListView listview = (ListView) findViewById(R.id.list);
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
                TextView count = (TextView) view.findViewById(R.id.count);
                // checking if no. of sets_done equal to Total no. of sets
                if (obj.getCountDone().compareTo(obj.getTotalSets())!=0)
                    count.setText(obj.getCountDone()+" / "+obj.getTotalSets());

                else {
                    count.setText("DONE");

                    // Set the theme color for the list item when done
                    View textContainer = view.findViewById(R.id.EachElement);
                    // Find the color that the resource ID maps to
                    int color = ContextCompat.getColor(getApplicationContext(), R.color.Completed_task);
                    textContainer.setBackgroundColor(color);

                    Toast.makeText(getApplicationContext(),"Well Done!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
