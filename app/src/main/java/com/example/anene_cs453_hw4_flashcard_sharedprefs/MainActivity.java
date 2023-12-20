package com.example.anene_cs453_hw4_flashcard_sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // magic
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // link start button between xml and java
        Button startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MenuOptions.class));
        });
    }
}