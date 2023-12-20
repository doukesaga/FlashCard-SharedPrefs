package com.example.anene_cs453_hw4_flashcard_sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Iterator;
import java.util.Map;

public class StudyDeckActivity extends AppCompatActivity {
    private boolean showCapital = false;
    private Map.Entry<String, String> country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // magic
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_deck);

        // get deck data
        DeckData countries = DeckData.getInstance();

        // get flag data from intent and set background color
        if (getIntent().getBooleanExtra("background", false)){
            findViewById(R.id.maincolor).setBackgroundColor(getResources().getColor(R.color.teal));
        }
        // iterator to traverse capitals data from deck data
        Iterator<Map.Entry<String, String>> getCountry = countries.capitals.entrySet().iterator();

        // flashcard as a button, link java and xml button
        Button cardButton = findViewById(R.id.card_button);

        // when button is clicked, display country name, then capital name
        cardButton.setOnClickListener(v -> {
            if (showCapital) {
                // show capital
                cardButton.setText(country.getValue());

                // reset flag
                showCapital = false;
            } else {
                if (getCountry.hasNext()) {
                    // get an country element data
                    country = getCountry.next();

                    // loop to check if country has already been studied
                    while (Boolean.TRUE.equals(countries.studied.get(country.getKey())) && getCountry.hasNext()) {
                        country = getCountry.next();
                    }

                    // display country name
                    cardButton.setText("What is the Capital of " + country.getKey());

                    // trigger flag to show capital
                    showCapital = true;

                    // add country to studied countries in deck data with value true
                    countries.studied.put(country.getKey(), true);
                } else {
                    cardButton.setText("No more countries to study!");
                }
            }
        });


        // return to menu options
        Button returnButton = findViewById(R.id.return_button);
        returnButton.setOnClickListener(v -> {
            Intent returnToMenu = new Intent(this, MenuOptions.class);
            startActivity(returnToMenu);
        });
    }
}
