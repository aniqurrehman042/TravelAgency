package com.example.travelagency.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.travelagency.R;
import com.example.travelagency.adapters.SearchFlightsAdapter;

public class SearchFlights extends AppCompatActivity {

    ViewPager vpSearchFlights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_flights);

        findViews();
        initializeActivity();

    }

    private void findViews() {
        vpSearchFlights = findViewById(R.id.vp_search_flights);
    }

    private void initializeActivity() {
        SearchFlightsAdapter searchFlightsAdapter = new SearchFlightsAdapter(getSupportFragmentManager());
        vpSearchFlights.setAdapter(searchFlightsAdapter);
    }

    public void backClick(View view) {
        finish();
    }
}
