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
import android.view.View;
import android.view.ViewGroup;

import com.creativeconsillium.drumsforafrica.kopo.Adapter.ReportProvidersAdapter;
import com.creativeconsillium.drumsforafrica.kopo.Model.ReportProvider;
import com.creativeconsillium.drumsforafrica.kopo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment class for Reports.
 *
 * Created by Edward N. Ndukui,
 * on Sunday, 23rd/June/2019,
 * at 02:11PM.
 */
public class FragReports extends Fragment {

    private Context coxContext;

    private List<ReportProvider> lsReportLoanProviders;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.coxContext = context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View vFragReports = inflater.inflate(R.layout.frag_reports, container, false);

        initializeVariablesAndUIObjects(vFragReports);

        return vFragReports;
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
                abActivityActionBar.setTitle(getString(R.string.title_fragment_reports));
                abActivityActionBar.setDisplayHomeAsUpEnabled(true);
                abActivityActionBar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_action_back));
            }

        }

        lsReportLoanProviders = new ArrayList<>();

        ReportProvidersAdapter clsAdapterReportProviders = new ReportProvidersAdapter(lsReportLoanProviders);

        RecyclerView rvTopLoanProviders = (RecyclerView) fragmentLayout.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(coxContext);
        rvTopLoanProviders.setLayoutManager(mLayoutManager);
        rvTopLoanProviders.setItemAnimator(new DefaultItemAnimator());
        rvTopLoanProviders.setAdapter(clsAdapterReportProviders);

        codeToPrepareReportProvidersData();

    }

    /**
     * Method to prepare report providers data.
     * This data is static.
     *
     * Called In:
     *          - this.initializeVariablesAndUIObjects();
     */
    private void codeToPrepareReportProvidersData() {

        lsReportLoanProviders.add(new ReportProvider("1", "Ksh 24,000", "10 loans", "Interest Ksh 3,440.", R.drawable.loan_tala));
        lsReportLoanProviders.add(new ReportProvider("2", "Ksh 14,000", "5 loans", "Interest Ksh 2,600.", R.drawable.loan_branch));
        lsReportLoanProviders.add(new ReportProvider("3", "Ksh 8,000", "8 loans", "Interest Ksh 1,540.", R.drawable.loan_kcbmpesa));
        lsReportLoanProviders.add(new ReportProvider("4", "Ksh 6,400", "2 loans", "Interest Ksh 840.", R.drawable.loan_mshwari));

    }

}
