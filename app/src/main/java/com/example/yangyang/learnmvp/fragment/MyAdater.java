package com.example.yangyang.learnmvp.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.base.base.BaseFragment;

import java.util.List;

public class MyAdater extends FragmentPagerAdapter {
    List<BaseFragment> fragments;
    public MyAdater(FragmentManager fm ,List<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
