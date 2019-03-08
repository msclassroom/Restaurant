package io.github.vinge1718.restaurant.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vinge1718.restaurant.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.registerTextView) TextView mRegisterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mRegisterTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view == mRegisterTextView){
            Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
