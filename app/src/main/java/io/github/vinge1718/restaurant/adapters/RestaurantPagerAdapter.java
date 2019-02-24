package io.github.vinge1718.restaurant.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import io.github.vinge1718.restaurant.models.Restaurant;
import io.github.vinge1718.restaurant.ui.RestaurantDetailFragment;

public class RestaurantPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Restaurant> mRestaurants;

    public RestaurantPagerAdapter(FragmentManager fm, ArrayList<Restaurant> restaurants){
        super(fm);
        mRestaurants = restaurants;
    }

    @Override
    public Fragment getItem(int position){
        return RestaurantDetailFragment.newInstance(mRestaurants.get(position));
    }

    @Override
    public int getCount(){
        return mRestaurants.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mRestaurants.get(position).getName();
    }
}
