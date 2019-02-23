package io.github.vinge1718.restaurant;

import android.widget.ListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import io.github.vinge1718.restaurant.ui.RestaurantListActivity;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(RobolectricTestRunner.class)

public class RestaurantListActivityTest {
    private RestaurantListActivity activity;
    private ListView mRestaurantListView;

    @Before
    public void setup(){
        activity = Robolectric.setupActivity(RestaurantListActivity.class);
        mRestaurantListView = (ListView) activity.findViewById(R.id.listView);
    }

    @Test
    public void restaurantListViewPopulates() {
        assertNotNull(mRestaurantListView.getAdapter());
        assertEquals(mRestaurantListView.getAdapter().getCount(), 15);
    }
}
