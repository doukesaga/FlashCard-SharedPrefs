package com.example.anene_cs453_hw4_flashcard_sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {
private Switch progressSwitch, colorSwitch;

public static final String SHARED_PREFS = "sharedPrefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // magic
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // link progress switch between xml and java
        progressSwitch = findViewById(R.id.progress_switch);
        colorSwitch = findViewById(R.id.background_switch);

        // get flag data from intent and set background color
        if (getIntent().getBooleanExtra("background", false)){
            findViewById(R.id.maincolor).setBackgroundColor(getResources().getColor(R.color.teal));
        }

        // get data from shared preferences
        SharedPreferences SharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = SharedPreferences.edit();

        // use shared preferences to save progress
        progressSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editor.putBoolean("progress", progressSwitch.isChecked());
            editor.apply();
        });

        // use shared preferences to save progress
        colorSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editor.putBoolean("background", colorSwitch.isChecked());
            editor.apply();
        });

        // load updated data from shared preferences
        progressSwitch.setChecked(SharedPreferences.getBoolean("progress", false));
        colorSwitch.setChecked(SharedPreferences.getBoolean("background", false));

        // update views
        progressSwitch.setChecked(progressSwitch.isChecked());
        colorSwitch.setChecked(colorSwitch.isChecked());

        // return to menu options
        Button returnButton = findViewById(R.id.return_button);
        returnButton.setOnClickListener(v -> {
            startActivity(new Intent(SettingsActivity.this, MenuOptions.class));
        });
    }
}