package io.github.vinge1718.restaurant;

public class Constants {
    public static final String YELP_TOKEN = BuildConfig.YELP_TOKEN;
    public static final String YELP_BASE_URL = "https://api.yelp.com/v3/businesses/search";
    public static final String YELP_LOCATION_QUERY_PARAMETER = "location";

    //Data persistence _ Shared Preferences
    public static final String PREFERENCES_LOCATION_KEY = "location";
    //Child node name for saving the values for searched Locations in Firebase
    public static final String FIREBASE_CHILD_SEARCHED_LOCATION = "searchedLocation";
}
