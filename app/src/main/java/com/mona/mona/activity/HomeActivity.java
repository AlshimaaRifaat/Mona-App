package com.mona.mona.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mona.mona.R;
import com.mona.mona.fragment.HomeFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportFragmentManager().beginTransaction().replace(R.id.home_container
                ,new HomeFragment()).commit();
    }
}
