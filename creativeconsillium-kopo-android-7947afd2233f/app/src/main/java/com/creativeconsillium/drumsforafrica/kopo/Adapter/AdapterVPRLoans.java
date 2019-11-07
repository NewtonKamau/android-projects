package com.creativeconsillium.drumsforafrica.kopo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.creativeconsillium.drumsforafrica.kopo.Fragments.FragPaidLoans;
import com.creativeconsillium.drumsforafrica.kopo.Fragments.FragUnpaidLoans;


public class AdapterVPRLoans extends FragmentStatePagerAdapter {

    private int mNumOfTabs;

    public AdapterVPRLoans(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                return new FragUnpaidLoans();

            case 1:
                return new FragPaidLoans();

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }


}
