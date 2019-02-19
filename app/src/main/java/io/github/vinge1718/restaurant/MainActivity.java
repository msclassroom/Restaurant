package io.github.vinge1718.restaurant;

import android.graphics.Typeface;
import android.os.Bundle;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Type;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface caviarFont = Typeface.createFromAsset(getAssets(), "fonts/CaviarDreams.ttf");
        mAppNameTextView.setTypeface(caviarFont);
        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
                String location = mLocationEditText.getText().toString();
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });
    }
}
