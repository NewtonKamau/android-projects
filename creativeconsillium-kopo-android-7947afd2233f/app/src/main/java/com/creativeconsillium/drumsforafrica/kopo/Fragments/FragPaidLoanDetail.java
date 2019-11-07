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

import com.creativeconsillium.drumsforafrica.kopo.Adapter.LoansPaidDetailAdapter;
import com.creativeconsillium.drumsforafrica.kopo.Model.LoansPaidDetail;
import com.creativeconsillium.drumsforafrica.kopo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment class for Details of an Paid Loan.
 *
 * Created by Edward N. Ndukui,
 * on Monday, 24th/June/2019,
 * at 4:29AM.
 */
public class FragPaidLoanDetail extends Fragment {

    private Context coxContext;

    private List<LoansPaidDetail> lsPaidLoans;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.coxContext = context;

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View vFragPaidLoanDetail = inflater.inflate(R.layout.frag_paid_loan_detail, container, false);

        initializeVariablesAndUIObjects(vFragPaidLoanDetail);

        return vFragPaidLoanDetail;
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
                abActivityActionBar.setTitle(getString(R.string.title_fragment_paid_loan));
                abActivityActionBar.setDisplayHomeAsUpEnabled(true);
                abActivityActionBar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_action_back));
            }

        }

        lsPaidLoans = new ArrayList<>();

        LoansPaidDetailAdapter clsAdapterPaidLoanDetail = new LoansPaidDetailAdapter(lsPaidLoans);

        RecyclerView rvUnpaidLoans = (RecyclerView) fragmentLayout.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager rvlmLayoutManager = new LinearLayoutManager(coxContext);
        rvUnpaidLoans.setLayoutManager(rvlmLayoutManager);
        rvUnpaidLoans.setItemAnimator(new DefaultItemAnimator());
        rvUnpaidLoans.setAdapter(clsAdapterPaidLoanDetail);

        codeToPreparePaidLoanDetailData();

    }

    /**
     * Method to prepare data of the Paid loans of the specified Provider.
     *
     * Called In:
     *          - this.initializeVariablesAndUIObjects();
     */
    private void codeToPreparePaidLoanDetailData() {

        lsPaidLoans.add(new LoansPaidDetail("21st Feb 19", "Ksh 1,500", "2nd Mar 19", "Ksh 246"));
        lsPaidLoans.add(new LoansPaidDetail("3rd Mar 19", "Ksh2,500", "12th Mar 19", "Ksh 346"));
        lsPaidLoans.add(new LoansPaidDetail("22nd Mar 19", "Ksh 5,500", "2nd Apr 19", "Ksh 746"));
        lsPaidLoans.add(new LoansPaidDetail("4th Apr 19", "Ksh 7,000", "12th Apr 19", "Ksh 812"));
        lsPaidLoans.add(new LoansPaidDetail("16th Apr 19", "Ksh 9,500", "24th Apr 19", "Ksh 945"));

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
