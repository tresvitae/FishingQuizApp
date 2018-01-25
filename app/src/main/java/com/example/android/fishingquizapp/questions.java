package com.example.android.fishingquizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tresvitae on 2018-01-16.
 */

public class questions extends AppCompatActivity {

    int totalPoints;
    RadioButton q1Answer3;
    RadioButton q2Answer1;
    RadioButton q3Answer1;
    RadioButton q4Answer3;
    RadioButton q5Answer1;
    RadioButton q6Answer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        Toast.makeText(getApplicationContext(), "Lets start", Toast.LENGTH_SHORT).show();
    }

    public void submit(View view) {
/**
 * This code displays the given text on the submit_window screen.
 */
        Intent myIntent = new Intent(questions.this, submitWindow.class);
        int totalPoints = countPoints();
        myIntent.putExtra("totalPoints", totalPoints);
        startActivity(myIntent);
    }

    public int countPoints() {
        totalPoints = 0;

        // Correct buttons set up to count
        q1Answer3 = findViewById(R.id.q1_answer3);
        q2Answer1 = findViewById(R.id.q2_answer1);
        q3Answer1 = findViewById(R.id.q3_answer1);
        q4Answer3 = findViewById(R.id.q4_answer3);
        q5Answer1 = findViewById(R.id.q5_answer1);
        q6Answer2 = findViewById(R.id.q6_answer2);

        /**
         * Implemented for readability.
         */
        CheckBox q7Option1 = findViewById(R.id.q7_option1);
        boolean hasQ7Option1 = q7Option1.isChecked();
        Log.v("MainActivity", "Correct q7Option1: " + hasQ7Option1);

        /**
         * This code count questions if are true.
         */
        CheckBox q7Option2 = findViewById(R.id.q7_option2);
        boolean hasQ7Option2 = q7Option2.isChecked();
        Log.v("MainActivity", "Correct q7Option2: " + hasQ7Option2);

        CheckBox q7Option3 = findViewById(R.id.q7_option3);
        boolean hasQ7Option3 = q7Option3.isChecked();
        Log.v("MainActivity", "Correct q7Option3: " + hasQ7Option3);

        if (q1Answer3.isChecked()) {
            totalPoints += 1;
        }
        if (q2Answer1.isChecked()) {
            totalPoints += 1;
        }
        if (q3Answer1.isChecked()) {
            totalPoints += 1;
        }
        if (q4Answer3.isChecked()) {
            totalPoints += 1;
        }
        if (q5Answer1.isChecked()) {
            totalPoints += 1;
        }
        if (q6Answer2.isChecked()) {
            totalPoints += 1;
        }
        if (hasQ7Option2 && hasQ7Option3 && !hasQ7Option1) {
            totalPoints += 1;
        }
        return totalPoints;
    }
}


//    RadioButton q1Answer1;
//    RadioButton q1Answer2;
//    RadioButton q2Answer2;
//    RadioButton q2Answer3;
//    RadioButton q3Answer2;
//    RadioButton q3Answer3;
//    RadioButton q4Answer1;
//    RadioButton q4Answer2;
//    RadioButton q5Answer2;
//    RadioButton q5Answer3;
//    RadioButton q6Answer1;
//    RadioButton q6Answer3;

//// Wrong buttons
//        q1Answer1 = findViewById(R.id.q1_answer1);
//                q1Answer2 = findViewById(R.id.q1_answer2);
//                q1Answer3 = findViewById(R.id.q1_answer3);
//                q2Answer2 = findViewById(R.id.q2_answer2);
//                q2Answer3 = findViewById(R.id.q2_answer3);
//                q3Answer1 = findViewById(R.id.q3_answer1);
//                q3Answer2 = findViewById(R.id.q3_answer2);
//                q3Answer3 = findViewById(R.id.q3_answer3);
//                q4Answer1 = findViewById(R.id.q4_answer1);
//                q4Answer2 = findViewById(R.id.q4_answer2);
//                q4Answer3 = findViewById(R.id.q4_answer3);
//                q5Answer1 = findViewById(R.id.q5_answer1);
//                q5Answer2 = findViewById(R.id.q5_answer2);
//                q5Answer3 = findViewById(R.id.q5_answer3);
//                q6Answer1 = findViewById(R.id.q6_answer1);
//                q6Answer2 = findViewById(R.id.q6_answer2);
//                q6Answer3 = findViewById(R.id.q6_answer3);
//
//                //inform if you not chosen any button in particular question
//                if ((q1Answer1.isChecked() || q1Answer2.isChecked() || q1Answer3.isChecked())
//                && (q2Answer1.isChecked() || q2Answer2.isChecked() || q2Answer3.isChecked())
//                && (q3Answer1.isChecked() || q3Answer2.isChecked() || q3Answer3.isChecked())
//                && (q4Answer1.isChecked() || q4Answer2.isChecked() || q4Answer3.isChecked())
//                && (q5Answer1.isChecked() || q5Answer2.isChecked() || q5Answer3.isChecked())
//                && (q6Answer1.isChecked() || q6Answer2.isChecked() || q6Answer3.isChecked())) {
//        } else {
//                Toast.makeText(getApplicationContext(), "You did not answer to all questions", Toast.LENGTH_SHORT).show();
//                }
