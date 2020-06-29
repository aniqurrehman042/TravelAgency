package com.example.travelagency.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.travelagency.ui.fragments.OneWayFragment;
import com.example.travelagency.ui.fragments.RoundTripFragment;

public class SearchFlightsAdapter extends FragmentPagerAdapter {

    public SearchFlightsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch(i) {
            case 0:
                Fragment oneWay = new OneWayFragment();
                return oneWay;
            case 1:
                Fragment roundTrip = new RoundTripFragment();
                return roundTrip;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "One Way Trip";
            case 1:
                return "Round Trip";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
