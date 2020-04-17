package com.example.c0782918_w2020_mad3125_fp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.c0782918_w2020_mad3125_fp.fragments.CusHydro;
import com.example.c0782918_w2020_mad3125_fp.fragments.CusInternet;
import com.example.c0782918_w2020_mad3125_fp.fragments.CusMobile;

public class PagerAdapter extends FragmentPagerAdapter {

    private int noOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int noOfTabs) {
        super(fm, noOfTabs);
        this.noOfTabs = noOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
                return new CusHydro();
            case 1:
                return new CusInternet();
            case 2:
                return new CusMobile();
        }
        return null;

    }

    @Override
    public int getCount() {
        return noOfTabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
