package com.mona.mona.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mona.mona.R;

public class LoginActivity extends AppCompatActivity {
Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( LoginActivity.this,NavigationActivity.class );
                startActivity( intent );
            }
        });
    }

    private void init() {
        loginBtn=findViewById(R.id.btn_login);
    }
}
