package com.meizhuo.yirightsprotection.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 何子强 on 2019/2/23
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private List<String> titleList;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        fragmentList = fragments;
        titleList = titles;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }
}
