package com.example.anene_cs453_hw4_flashcard_sharedprefs;

import java.io.Serializable;
import java.util.HashMap;

public class DeckData implements Serializable {
    private static final DeckData instance = new DeckData();
    public HashMap<String, String> capitals = new HashMap<>();
    public HashMap<String, Boolean> studied = new HashMap<>();

    private DeckData() {
        // default deck of capitals
        capitals.put("USA", "Washington D.C.");
        capitals.put("Nigeria", "Abuja");
        capitals.put("Egypt", "Cairo");
        capitals.put("South Africa", "Pretoria");
        capitals.put("Kenya", "Nairobi");
        capitals.put("Ethiopia", "Addis Ababa");
        capitals.put("Ghana", "Accra");
        capitals.put("Morocco", "Rabat");
        capitals.put("Uganda", "Kampala");
        capitals.put("Algeria", "Algiers");
        capitals.put("Tanzania", "Dodoma");
        capitals.put("Sudan", "Khartoum");
        capitals.put("Mali", "Bamako");
        capitals.put("Somalia", "Mogadishu");
        capitals.put("Zambia", "Lusaka");
        capitals.put("Senegal", "Dakar");
    }

    public static DeckData getInstance() {
        return instance;
    }
}
