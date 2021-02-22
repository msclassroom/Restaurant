package io.github.vinge1718.restaurant.ui;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vinge1718.restaurant.Constants;
import io.github.vinge1718.restaurant.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.savedRestaurantsButton) Button mSavedRestaurantsButton;
    @BindView(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mFindRestaurantsButton.setOnClickListener(this);
        mSavedRestaurantsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v == mFindRestaurantsButton) {
            Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
            startActivity(intent);
        }
        if (v == mSavedRestaurantsButton) {
            Intent intent = new Intent(MainActivity.this, SavedRestaurantListActivity.class);
            startActivity(intent);
        }
    }

}
