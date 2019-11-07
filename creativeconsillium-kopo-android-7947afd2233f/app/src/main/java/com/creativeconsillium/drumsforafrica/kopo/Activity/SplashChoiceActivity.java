package com.creativeconsillium.drumsforafrica.kopo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.creativeconsillium.drumsforafrica.kopo.R;

public class SplashChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_choice);
    }


    public void openLogIn (View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        this.finish();
    }


    public void openSignUp (View view) {
        Intent i = new Intent(this, SignupActivity.class);
        startActivity(i);
        this.finish();
    }


}
