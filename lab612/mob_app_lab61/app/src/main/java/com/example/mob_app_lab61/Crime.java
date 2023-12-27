package com.example.mob_app_lab61;

import java.util.Date;
import java.util.UUID;

public class Crime {
    UUID id = UUID.randomUUID();
    String title = "";
    Date date = new Date();
    Boolean isSolved = false;
}
