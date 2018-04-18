package com.example.vlada.bacautourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ContentAdapter extends FragmentPagerAdapter {
    private Context mContext;

    //Create new object
    public ContentAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
    }

    //Get item at a specific position
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AccommodationFragment();
        } else if (position == 1) {
            return new CultureFragment();
        } else if (position == 2) {
            return new NatureFragment();
        } else {
            return new LeisureFragment();
        }
    }

    //Get number of items
    @Override
    public int getCount() {
        return 4;
    }

    //Get the title according the position
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.hotels);
        } else if (position == 1) {
            return mContext.getString(R.string.culture);
        } else if (position == 2) {
            return mContext.getString(R.string.nature_sights);
        } else {
            return mContext.getString(R.string.leisure);
        }
    }
}
