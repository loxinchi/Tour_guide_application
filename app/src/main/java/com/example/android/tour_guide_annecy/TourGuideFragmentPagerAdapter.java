package com.example.android.tour_guide_annecy;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class TourGuideFragmentPagerAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    public TourGuideFragmentPagerAdapter(Context context, @NonNull FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @NonNull
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HotFragment();
        } else if (position == 1) {
            return new FoodFragment();
        } else if (position == 2) {
            return new TourFragment();
        } else {
            return new HotelFragment();
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.hot_tab_title);
        } else if (position == 1) {
            return mContext.getString(R.string.food_tab_title);
        } else if (position == 2) {
            return mContext.getString(R.string.tour_tab_title);
        } else {
            return mContext.getString(R.string.hotel_tab_title);
        }
    }
}



