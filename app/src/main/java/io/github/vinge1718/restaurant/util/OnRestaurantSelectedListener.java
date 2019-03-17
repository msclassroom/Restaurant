package io.github.vinge1718.restaurant.util;

import java.util.ArrayList;

import io.github.vinge1718.restaurant.models.Restaurant;

public interface OnRestaurantSelectedListener {
    public void onRestaurantSelected(Integer position, ArrayList<Restaurant> restaurants);
}
