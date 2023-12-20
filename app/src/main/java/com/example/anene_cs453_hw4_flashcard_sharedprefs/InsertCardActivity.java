package com.example.anene_cs453_hw4_flashcard_sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // magic
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_card);

        // get deck data
        DeckData countries = DeckData.getInstance();

        // get flag data from intent and set background color
        if (getIntent().getBooleanExtra("background", false)){
            findViewById(R.id.maincolor).setBackgroundColor(getResources().getColor(R.color.teal));
        }

        // link inputs variables java backend to xml frontend
        EditText country = findViewById(R.id.country);
        EditText capital = findViewById(R.id.capital);

        // user error and success messages
        CharSequence errorMessage = "country already exists!";
        CharSequence successMessage = "country added!";

        // add user input to deck data
        Button addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(v -> {
            // check if country already exists
            if (countries.capitals.containsKey(country.getText().toString())) {
                // display error message
                capital.setError(errorMessage);
                Toast toast = Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT);
                toast.show();
            }
            else {
                // add country and capital to deck data
                countries.capitals.put(country.getText().toString(), capital.getText().toString());

                // display success message
                Toast toast = Toast.makeText(this, successMessage, Toast.LENGTH_SHORT);
                toast.show();
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