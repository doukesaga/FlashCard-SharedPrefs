package com.example.anene_cs453_hw4_flashcard_sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuOptions extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // magic
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_options);

        // menu setup with listview and adapter
        ListView menu = findViewById(R.id.list_view);
        String[] menuOptions = {"Insert a Card", "Study Deck", "Progress Report", "Settings"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, menuOptions);
        menu.setAdapter(adapter);

        // get shared preferences of background color
        SharedPreferences sharedPreferences = getSharedPreferences(SettingsActivity.SHARED_PREFS, MODE_PRIVATE);
        boolean background = sharedPreferences.getBoolean("background", false);

        // if background is true, change listview background color
        if (background){
            menu.setBackgroundColor(getResources().getColor(R.color.teal));
        }

        // branch menu activities
        menu.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent;
                    switch (position) {
                        case 0:
                            // go to activity and pass background boolean
                            intent = new Intent(this, InsertCardActivity.class);
                            intent.putExtra("background", background);
                            startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(this, StudyDeckActivity.class);
                            intent.putExtra("background", background);
                            startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(this, ProgressReportActivity.class);
                            intent.putExtra("background", background);
                            startActivity(intent);
                            break;
                        case 3:
                            intent = new Intent(this, SettingsActivity.class);
                            intent.putExtra("background", background);
                            startActivity(intent);
                            break;
                    }
                }
        );
    }
}