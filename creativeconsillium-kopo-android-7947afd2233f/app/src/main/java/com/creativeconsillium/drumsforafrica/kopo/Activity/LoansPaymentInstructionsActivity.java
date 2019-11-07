package com.creativeconsillium.drumsforafrica.kopo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.creativeconsillium.drumsforafrica.kopo.Adapter.LoanPaymentInstructionsAdapter;
import com.creativeconsillium.drumsforafrica.kopo.Model.LoansPaymentInstruction;
import com.creativeconsillium.drumsforafrica.kopo.R;

import java.util.ArrayList;
import java.util.List;

public class LoansPaymentInstructionsActivity extends AppCompatActivity {


    private List<LoansPaymentInstruction> loansPaymentInstructionList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LoanPaymentInstructionsAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loans_payment_instructions);


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


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mAdapter = new LoanPaymentInstructionsAdapter(loansPaymentInstructionList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareLoanPaymentInstructionsData();
    }


    private void prepareLoanPaymentInstructionsData() {

        loansPaymentInstructionList.add(new LoansPaymentInstruction("1", "Go to your M-Pesa menu."));
        loansPaymentInstructionList.add(new LoansPaymentInstruction("2", "Select Lipa na M-Pesa, then Pay Bill."));
        loansPaymentInstructionList.add(new LoansPaymentInstruction("3", "Enter business No. 012345."));
        loansPaymentInstructionList.add(new LoansPaymentInstruction("4", "Enter account No. 012345."));
        loansPaymentInstructionList.add(new LoansPaymentInstruction("5", "Enter your loan payment amount."));
        loansPaymentInstructionList.add(new LoansPaymentInstruction("6", "Enter your M-Pesa PIN and confirm."));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.actionAccount) {
            Intent i = new Intent(this, AccountActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }


}
