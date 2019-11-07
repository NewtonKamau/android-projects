package com.creativeconsillium.drumsforafrica.kopo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.creativeconsillium.drumsforafrica.kopo.R;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        // Add back navigation to toolbar back button
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


    public void openAccountProfile (View view) {
        Intent i = new Intent(this, AccountProfileActivity.class);
        startActivity(i);
    }


    public void openAccountNotification (View view) {
        Intent i = new Intent(this, AccountNotificationActivity.class);
        startActivity(i);
    }


    public void openAccountChangePin (View view) {
        Intent i = new Intent(this, AccountChangePinActivity.class);
        startActivity(i);
    }


    public void openAccountLoanProviders (View view) {
        Intent i = new Intent(this, AccountLoanProvidersActivity.class);
        startActivity(i);
    }


    public void openAccountDebtLimit (View view) {
        Intent i = new Intent(this, AccountDebtLimitActivity.class);
        startActivity(i);
    }


    public void openAccountBackup (View view) {
        Intent i = new Intent(this, AccountBackupActivity.class);
        startActivity(i);
    }


    /*
    public void openAccountHow(View view) {
        Intent i = new Intent(this, AccountHowActivity.class);
        startActivity(i);
    }
    */


    public void openAccountAbout (View view) {
        Intent i = new Intent(this, AccountAboutActivity.class);
        startActivity(i);
    }


}
