package com.example.fitnesstracker;

// class to store the features of an exercise to be displayed
public class Exercise {

    private String mExerciseName;
    private int mImageResourceId;
    private int mCountDone;
    private int mTotalSets;

    public Exercise(String name, int totalsets, int CountDone, int img_resourse)
    {
        mExerciseName = name;
        mTotalSets = totalsets;
        mCountDone = CountDone;
        mImageResourceId = img_resourse;
    }

    //method to get exercise name
    public String getExerciseName() {
        return mExerciseName;
    }

    //method to get total no. of sets
    public String getTotalSets() {
        return Integer.toString(mTotalSets);
    }

    //method to get image resource
    public int getImageResource()
    {
        return mImageResourceId;
    }

    //method to increase no.of sets done
    public void IncreaseCountDone() {
        if (mCountDone < mTotalSets)
            mCountDone++;
    }

    //method to get no.of sets done
    public String getCountDone() {
        return Integer.toString(mCountDone);
    }

}
