package com.example.android.fishingquizapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.util.Set;

/**
 * Created by tresvitae on 2018-01-16.
 */

public class submitWindow extends AppCompatActivity {

    String message;
    String message2 = "Your score is: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.submit_window);

        int totalPoints = getIntent().getIntExtra("totalPoints", 0);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        String name = pref.getString("name", "");

        if (totalPoints <= 2) {
            message = "You need to practice!";
        } else if (totalPoints <= 4) {
            message = "Not bad!";
        } else if (totalPoints <= 6) {
            message = "Almost!";
        } else {
            message = "You are the best!";
        }

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .6), (int) (height * .3));

        displayScore(name, message2, message, totalPoints);
    }

    public void displayScore(String name, String message, String message2, int score) {

        // Display set name, count score and comment
        TextView orderSummaryView = (TextView) findViewById(R.id.su_window);
        orderSummaryView.setText(getString(R.string.su_window, name));
        TextView orderSummaryView2 = (TextView) findViewById(R.id.su_window2);
        orderSummaryView2.setText(message2);
        TextView orderSummaryView3 = findViewById(R.id.su_window3);
        orderSummaryView3.setText(String.valueOf(message));
        TextView orderSummaryView4 = (TextView) findViewById(R.id.su_window4);
        orderSummaryView4.setText(String.valueOf(score));
    }
}
















