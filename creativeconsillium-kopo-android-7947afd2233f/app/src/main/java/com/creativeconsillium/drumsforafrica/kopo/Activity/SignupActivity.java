package com.creativeconsillium.drumsforafrica.kopo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.creativeconsillium.drumsforafrica.kopo.R;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }


    public void openSplashChoice (View view) {
        Intent i = new Intent(this, SplashChoiceActivity.class);
        startActivity(i);
        this.finish();
    }


    public void openLoanProviders (View view) {
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
        this.finish();
    }


}
