package com.example.android.fishingquizapp;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

/**
 * Created by tresvitae on 2018-01-16.
 */

public class submitWindow extends AppCompatActivity {

    String message;
    String message2 = "Your score is: ";
    String scoreToEmail;

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

        getWindow().setLayout((int) (width * .6), (int) (height * .4));

        displayScore(name, message2, message, totalPoints);
    }

    public void sendEmail(View view) {

        int totalPoints = getIntent().getIntExtra("totalPoints", 0);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        String name = pref.getString("name", "");

        String messageToEmail = displayScore(name, message2, message, totalPoints);

        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setData(Uri.parse("mailto:"));
        email.putExtra(Intent.EXTRA_SUBJECT, "Hello " + name);
        email.putExtra(Intent.EXTRA_TEXT, messageToEmail);

        if (email.resolveActivity(getPackageManager()) != null) {
            startActivity(email);
        }
    }

    public String displayScore(String name, String message, String message2, int score) {

        // Display set name, count score and comment
        TextView orderSummaryView = (TextView) findViewById(R.id.su_window);
        orderSummaryView.setText(getString(R.string.su_window, name));
        TextView orderSummaryView2 = (TextView) findViewById(R.id.su_window2);
        orderSummaryView2.setText(message2);
        TextView orderSummaryView3 = findViewById(R.id.su_window3);
        orderSummaryView3.setText(String.valueOf(message));
        TextView orderSummaryView4 = (TextView) findViewById(R.id.su_window4);
        orderSummaryView4.setText(String.valueOf(score));
        return scoreToEmail;
    }
}
















