package com.example.mob_app_lab61;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

public class CrimeListViewModel extends ViewModel {
    List<Crime> crimes = new ArrayList<>();

    public CrimeListViewModel() {
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.title = "Crime #$i";
            crime.date = new Date();
            crime.isSolved = i % 2 == 0;
            crimes.add(crime);
        }
    }
}
