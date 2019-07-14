package com.mona.mona.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mona.mona.R;

public class LoginRegisterActivity extends AppCompatActivity {
Button loginBtn,registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        init();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( LoginRegisterActivity.this,LoginActivity.class );
                startActivity( intent );
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( LoginRegisterActivity.this,RegisterActivity.class );
                startActivity( intent );
            }
        });
    }

    private void init() {
        loginBtn=findViewById(R.id.btn_login);
        registerBtn=findViewById(R.id.btn_register);
    }
}
