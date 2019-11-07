package com.creativeconsillium.drumsforafrica.kopo.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.creativeconsillium.drumsforafrica.kopo.Adapter.AccountLoanProvidersAdapter;
import com.creativeconsillium.drumsforafrica.kopo.Model.AccountLoanProviderModel;
import com.creativeconsillium.drumsforafrica.kopo.R;

import java.util.ArrayList;
import java.util.List;

public class AccountLoanProvidersActivity extends AppCompatActivity {


    private List<AccountLoanProviderModel> accountLoanProviderModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AccountLoanProvidersAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_loan_providers);


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

        mAdapter = new AccountLoanProvidersAdapter(accountLoanProviderModelList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareLoanProviderData();
    }


    private void prepareLoanProviderData() {

        accountLoanProviderModelList.add(new AccountLoanProviderModel("Branch", R.drawable.loan_branch, "DEACTIVATE"));
        accountLoanProviderModelList.add(new AccountLoanProviderModel("KCB MPesa", R.drawable.loan_kcbmpesa, "DEACTIVATE"));
        accountLoanProviderModelList.add(new AccountLoanProviderModel("Mshwari", R.drawable.loan_mshwari, "DEACTIVATE"));
        accountLoanProviderModelList.add(new AccountLoanProviderModel("Okolea", R.drawable.loan_okolea, "DEACTIVATE"));
        accountLoanProviderModelList.add(new AccountLoanProviderModel("Tala", R.drawable.loan_tala, "DEACTIVATE"));

    }
}
