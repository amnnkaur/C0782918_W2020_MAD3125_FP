package com.example.c0782918_w2020_mad3125_fp.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.c0782918_w2020_mad3125_fp.fragments.CusHydro;
import com.example.c0782918_w2020_mad3125_fp.fragments.CusInternet;
import com.example.c0782918_w2020_mad3125_fp.fragments.CusMobile;
import com.example.c0782918_w2020_mad3125_fp.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> titleList = new ArrayList<>();

    private int noOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        /*switch (position){

            case 0:
                return new CusHydro();
            case 1:
                return new CusInternet();
            case 2:
                return new CusMobile();
        }*/
        return fragmentList.get(position);

    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }


    public void AddFragment(Fragment fragment, String title){

        fragmentList.add(fragment);
        titleList.add(title);

    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
