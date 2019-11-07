package com.creativeconsillium.drumsforafrica.kopo.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativeconsillium.drumsforafrica.kopo.Adapter.AdapterRVPaidLoans;
import com.creativeconsillium.drumsforafrica.kopo.Model.ModelPaidLoans;
import com.creativeconsillium.drumsforafrica.kopo.R;

import java.util.ArrayList;
import java.util.List;

public class FragPaidLoans extends Fragment {

    private Context coxContext;

    private List<ModelPaidLoans> lsPaidLoans;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.coxContext = context;

    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View vFragPaidLoans =inflater.inflate(R.layout.frag_paid_loans,container,false);

        initializeVariablesAndUIObjects(vFragPaidLoans);

        return vFragPaidLoans;
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

        lsPaidLoans = new ArrayList<>();

        AdapterRVPaidLoans clsAdapterPaidLoans = new AdapterRVPaidLoans(coxContext, lsPaidLoans);

        RecyclerView rvPaidLoans = (RecyclerView) fragmentLayout.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager rvlmLayoutManager = new LinearLayoutManager(getActivity());
        rvPaidLoans.setLayoutManager(rvlmLayoutManager);
        rvPaidLoans.setAdapter(clsAdapterPaidLoans);

        codeToPrepareLoansPaidData();

    }

    /**
     * Method to prepare data of the Paid loans.
     *
     * Called In:
     *          - this.initializeVariablesAndUIObjects();
     */
    private void codeToPrepareLoansPaidData() {

        lsPaidLoans.add(new ModelPaidLoans(R.drawable.loan_tala, "Ksh. 25,200", "8"));
        lsPaidLoans.add(new ModelPaidLoans(R.drawable.loan_kcbmpesa, "Ksh. 22,600", "4"));
        lsPaidLoans.add(new ModelPaidLoans(R.drawable.loan_branch, "Ksh. 22,400", "6"));
        lsPaidLoans.add(new ModelPaidLoans(R.drawable.loan_mshwari, "Ksh. 15,400", "3"));

    }

}