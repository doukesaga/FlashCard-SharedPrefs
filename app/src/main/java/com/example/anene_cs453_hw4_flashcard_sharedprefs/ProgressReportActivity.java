package com.example.anene_cs453_hw4_flashcard_sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Map;

public class ProgressReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // magic
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_report);

        // get countries studied data
        DeckData countries = DeckData.getInstance();
        int TOTAL_COUNTRIES = countries.capitals.size();

        // get flag data from intent and set background color
        if (getIntent().getBooleanExtra("background", false)){
            findViewById(R.id.maincolor).setBackgroundColor(getResources().getColor(R.color.teal));
        }

        // get shared preferences
        SharedPreferences SharedPreferences = getSharedPreferences(SettingsActivity.SHARED_PREFS, MODE_PRIVATE);
        boolean progress = SharedPreferences.getBoolean("progress", false);

        // loop through studied country and if value is true, increment studied
        int studied = 0;

        // if progress preference is true
        if (progress) {
            for (Map.Entry<String, Boolean> countryStudied : countries.studied.entrySet()) {
                if(countryStudied.getValue()){
                    studied++;
                }
            }
        }

        // setup progress bar
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        progressBar.setMax(TOTAL_COUNTRIES);
        progressBar.setProgress(studied);

        // set progress text to progress
        TextView progressText = findViewById(R.id.progress_text);
        progressText.setText(studied + " out of " + TOTAL_COUNTRIES + " countries studied");

        // after user clicks return button, return to menu options
        Button returnButton = findViewById(R.id.return_button);
        returnButton.setOnClickListener(v -> {
            startActivity(new Intent(this, MenuOptions.class));
        });
    }
}