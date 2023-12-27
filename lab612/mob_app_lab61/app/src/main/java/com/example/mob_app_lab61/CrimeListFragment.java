package com.example.mob_app_lab61;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

public class CrimeListFragment extends Fragment {
    private String TAG = "CrimeListFragment";
    private CrimeListViewModel crimeListViewModel;
    private RecyclerView crimeRecyclerView;
    CrimeAdapter adapter = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crimeListViewModel = new ViewModelProvider(this).get(CrimeListViewModel.class);
        Log.d(TAG, "Total Crimes: ${crimeListViewModel.crimes.size}");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        crimeRecyclerView = view.findViewById(R.id.crime_recycler_view);
        crimeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        updateUI();
        return view;
    }
    public void updateUI() {
        List<Crime> crimes = crimeListViewModel.crimes;

        if (adapter == null) {
            adapter = new CrimeAdapter(crimes);
            crimeRecyclerView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
        /*crimes = crimeListViewModel.crimes;
        adapter = new CrimeAdapter(crimes);
        crimeRecyclerView.setAdapter(adapter);*/
    }
    public class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {

        private List<Crime> crimes;

        public CrimeAdapter(List<Crime> crimes) {
            this.crimes = crimes;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_crime, parent, false);
            return new CrimeHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            Crime crime = crimes.get(position);
            holder.bind(crime);
        }

        @Override
        public int getItemCount() {
            return crimes.size();
        }
    }

    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Crime crime;

        TextView titleTextView = (TextView) itemView.findViewById(R.id.crime_title);
        TextView dateTextView = (TextView) itemView.findViewById(R.id.crime_date);
        public CrimeHolder(View view) {
            super(view);
            view.setOnClickListener(this);
        }
        public void bind(Crime crime) {
            this.crime = crime;
            titleTextView.setText(this.crime.title);
            dateTextView.setText(this.crime.date.toString());
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), crime.title + " pressed!", Toast.LENGTH_SHORT).show();
        }
    }
    /*public static CrimeListFragment newInstance() {
        return new CrimeListFragment();
    }*/
}
