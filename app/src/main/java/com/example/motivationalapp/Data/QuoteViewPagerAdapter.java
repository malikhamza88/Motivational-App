package com.example.motivationalapp.Data;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class QuoteViewPagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> mFragments;

    public QuoteViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {

        return mFragments.get(position);
    }

    @Override
    public int getCount() {

        return mFragments.size();
    }
}
