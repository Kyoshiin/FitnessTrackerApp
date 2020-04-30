package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int count_sets = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button increase = (Button) findViewById(R.id.incre);
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count_sets<20){
                    count_sets++;
                    display();}
                else
                    Toast.makeText(getApplicationContext(),"Too much for you!",Toast.LENGTH_SHORT).show();
            }
        });

        Button decrease = (Button) findViewById(R.id.decre);
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count_sets>0){
                    count_sets--;
                    display();}
                else
                    Toast.makeText(getApplicationContext(),"Too less!",Toast.LENGTH_SHORT).show();
            }
        });

        //When done button in pressed
        Button done = (Button) findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExerciseListAcitvity.class);
                intent.putExtra("count_sets",count_sets);
                startActivity(intent);
            }
        });
    }

    //Method for displaying updated no. of sets
    private void display() {
        TextView no_of_sets = (TextView) findViewById(R.id.no_of_sets);
        no_of_sets.setText(""+count_sets);
    }
}
