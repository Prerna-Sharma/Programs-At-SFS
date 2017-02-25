package com.example.student.fragmentsintablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.student.fragments.FirstFragmentActivity;
import com.example.student.fragments.SecondFragmentActivity;
import com.example.student.fragments.ThirdFragmentActivity;


public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private int tabCount;
    private FirstFragmentActivity firstFragmentActivity;
    private SecondFragmentActivity secondFragmentActivity;
    private ThirdFragmentActivity thirdFragmentActivity;

    public MyPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                firstFragmentActivity = new FirstFragmentActivity();
                return firstFragmentActivity;
            case 1:
                secondFragmentActivity = new SecondFragmentActivity();
                return secondFragmentActivity;
            case 2:
                thirdFragmentActivity = new ThirdFragmentActivity();
                return thirdFragmentActivity;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
