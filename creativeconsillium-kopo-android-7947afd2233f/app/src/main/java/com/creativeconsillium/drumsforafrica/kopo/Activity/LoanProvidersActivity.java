package com.creativeconsillium.drumsforafrica.kopo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.creativeconsillium.drumsforafrica.kopo.Adapter.LoanProvidersAdapter;
import com.creativeconsillium.drumsforafrica.kopo.Model.LoanProvider;
import com.creativeconsillium.drumsforafrica.kopo.R;

import java.util.ArrayList;
import java.util.List;

public class LoanProvidersActivity extends AppCompatActivity {


    private List<LoanProvider> loanProviderList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LoanProvidersAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_providers);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mAdapter = new LoanProvidersAdapter(loanProviderList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareLoanProviderData();
    }


    private void prepareLoanProviderData() {

        loanProviderList.add(new LoanProvider("Branch", R.drawable.loan_branch, R.drawable.tick_green));
        loanProviderList.add(new LoanProvider("Branch", R.drawable.loan_kcbmpesa, R.drawable.tick_green));
        loanProviderList.add(new LoanProvider("Branch", R.drawable.loan_mshwari, R.drawable.tick_green));
        loanProviderList.add(new LoanProvider("Branch", R.drawable.loan_okolea, R.drawable.tick_gray));
        loanProviderList.add(new LoanProvider("Branch", R.drawable.loan_tala, R.drawable.tick_green));

    }


    public void openSignUp (View view) {
        Intent i = new Intent(this, SignupActivity.class);
        startActivity(i);
        // This is sign up function.
    }


    public void openHome (View view) {
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }


}
