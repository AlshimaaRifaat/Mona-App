package com.mona.mona;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.mona.mona.activity.HomeActivity;
import com.mona.mona.activity.LoginActivity;
import com.mona.mona.activity.LoginRegisterActivity;
import com.mona.mona.activity.NavigationActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        Thread timer=new Thread(  )
        {
            @Override
            public void run() {
                super.run();
                try {
                    sleep( 4000 );

                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }finally {

                        Intent intent=new Intent( SplashActivity.this,LoginRegisterActivity.class);
                        startActivity( intent );

                    finish();
                }
            }
        };

        timer.start();

    }
}
