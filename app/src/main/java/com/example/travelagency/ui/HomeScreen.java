package com.example.travelagency.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.travelagency.R;
import com.example.travelagency.adapters.OffersAdapter;
import com.example.travelagency.adapters.TrendingAdapter;
import com.example.travelagency.models.Offers;
import com.example.travelagency.models.Trending;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView rvOffers;
    RecyclerView rvTrending;

    ArrayList<Offers> offersArrayList = new ArrayList<>();
    ArrayList<Trending> trendingArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        initializeDrawerToolbar();

        findViews();

        initializeActivity();

    }

    private void initializeDrawerToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView mTitle = toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(Color.BLACK);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void findViews() {
        rvOffers = findViewById(R.id.rv_offers);
        rvTrending = findViewById(R.id.rv_trending);
    }

    private void initializeActivity() {
        setOffersAdapter();
        setTrendingAdapter();
    }

    private void setTrendingAdapter() {
        RecyclerView.LayoutManager rvTrendingLayoutManager = new LinearLayoutManager(this);
        trendingArrayList.add(new Trending(R.drawable.dubai, "Dubai", 24000));
        trendingArrayList.add(new Trending(R.drawable.europe, "Europe", 50000));
        trendingArrayList.add(new Trending(R.drawable.kerala, "Kerala", 12000));
        trendingArrayList.add(new Trending(R.drawable.ladakh, "Ladakh", 15000));
        trendingArrayList.add(new Trending(R.drawable.singapore, "Singapore", 40000));
        TrendingAdapter trendingAdapter = new TrendingAdapter(trendingArrayList, this);
        ((LinearLayoutManager) rvTrendingLayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        rvTrending.setLayoutManager(rvTrendingLayoutManager);
        rvTrending.setAdapter(trendingAdapter);
    }

    private void setOffersAdapter() {
        RecyclerView.LayoutManager rvOffersLayoutManager = new LinearLayoutManager(this);
        offersArrayList.add(new Offers("Tour to Mumbai at 20% off"));
        offersArrayList.add(new Offers("Tour to Delhi at 10% off"));
        offersArrayList.add(new Offers("Tour to Dubai at 50% off"));
        offersArrayList.add(new Offers("Tour to Singapore at 5% off"));
        offersArrayList.add(new Offers("Tour to Istanbul at 1% off"));
        offersArrayList.add(new Offers("Tour to Paris at 90% off"));
        OffersAdapter offersAdapter = new OffersAdapter(offersArrayList, this);
        ((LinearLayoutManager) rvOffersLayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        rvOffers.setLayoutManager(rvOffersLayoutManager);
        rvOffers.setAdapter(offersAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_travel_utility) {
            startSearchFlights();
        } else if (id == R.id.nav_offers_discounts) {

        } else if (id == R.id.nav_share_app) {

        } else if (id == R.id.nav_nav_rate_app) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_contact_us) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void flightClick(View view) {
        startSearchFlights();
    }

    public void startSearchFlights(){
        startActivity(new Intent(this, SearchFlights.class));
    }
}
