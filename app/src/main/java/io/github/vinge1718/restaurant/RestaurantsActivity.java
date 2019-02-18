package io.github.vinge1718.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RestaurantsActivity extends AppCompatActivity {
    private TextView mLocationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView = (TextView) findViewById(R.id.locationTextView);
        mLocationTextView.setText("Here are all the restaurants around " + location);
    }
}
