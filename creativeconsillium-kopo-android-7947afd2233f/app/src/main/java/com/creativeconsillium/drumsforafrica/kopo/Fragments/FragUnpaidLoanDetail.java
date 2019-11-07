package com.creativeconsillium.drumsforafrica.kopo.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.creativeconsillium.drumsforafrica.kopo.Adapter.LoansUnpaidDetailAdapter;
import com.creativeconsillium.drumsforafrica.kopo.Interfaces.InterfaceHome;
import com.creativeconsillium.drumsforafrica.kopo.Model.LoansUnpaidDetail;
import com.creativeconsillium.drumsforafrica.kopo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment class for Details of an Unpaid Loan.
 *
 * Created by Edward N. Ndukui,
 * on Sunday, 23rd/June/2019,
 * at 06:16PM.
 */
public class FragUnpaidLoanDetail extends Fragment {

    private InterfaceHome interHome;

    private Context coxContext;

    private List<LoansUnpaidDetail> lsUnpaidLoans;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            interHome = (InterfaceHome) context;
        } catch (ClassCastException ccex) {
            throw new ClassCastException(getActivity() + " MUST Implement InterfaceHome! ccex: " + ccex);
        }

        this.coxContext = context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View vFragUnpaidLoanDetail = inflater.inflate(R.layout.frag_unpaid_loan_detail, container, false);

        initializeVariablesAndUIObjects(vFragUnpaidLoanDetail);

        return vFragUnpaidLoanDetail;
    }


    /**
     * Method to declare and initialize class variables and UI Objects used in this Fragment.
     *
     * Called In:
     *          - (Override) this.onCreateView();
     *
     * @param fragmentLayout                                    (View)
     */
    private void initializeVariablesAndUIObjects(@NonNull View fragmentLayout) {

        AppCompatActivity acactParentActivity = (AppCompatActivity) getActivity();
        if (acactParentActivity != null) {

            ActionBar abActivityActionBar = acactParentActivity.getSupportActionBar();
            if (abActivityActionBar != null) {
                abActivityActionBar.setTitle(getString(R.string.title_fragment_unpaid_loan));
                abActivityActionBar.setDisplayHomeAsUpEnabled(true);
                abActivityActionBar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_action_back));
            }

        }

        lsUnpaidLoans = new ArrayList<>();

        LoansUnpaidDetailAdapter clsAdapterUnpaidLoanDetail = new LoansUnpaidDetailAdapter(lsUnpaidLoans);

        Button btnPayLoan = (Button) fragmentLayout.findViewById(R.id.btnAccountNotificationSaveSettings);
        btnPayLoan.setOnClickListener(clkUnpaidLoanDetail);

        RecyclerView rvUnpaidLoans = (RecyclerView) fragmentLayout.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(coxContext);
        rvUnpaidLoans.setLayoutManager(mLayoutManager);
        rvUnpaidLoans.setItemAnimator(new DefaultItemAnimator());
        rvUnpaidLoans.setAdapter(clsAdapterUnpaidLoanDetail);

        codeToPrepareUnpaidLoanDetailData();

    }

    /**
     * Method to prepare data of the unpaid loans of the specified Provider.
     *
     * Called In:
     *          - this.initializeVariablesAndUIObjects();
     */
    private void codeToPrepareUnpaidLoanDetailData() {

        lsUnpaidLoans.add(new LoansUnpaidDetail("15th May 19", "Ksh 2,500", "2nd May 19", "Ksh 246"));

    }


    /**
     * View.OnClickListener interface for handling clicks on views on this Fragment.
     *
     * Implemented In:
     *          - this.initializeVariablesAndUIObjects();
     */
    private View.OnClickListener clkUnpaidLoanDetail = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

        if (view.getId() == R.id.btnAccountNotificationSaveSettings) {
            //  TODO: Handle Pay Loan here using Interface
            interHome.codeToOpenLoanPayment();
        }

        }

    };


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
