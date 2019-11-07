package com.creativeconsillium.drumsforafrica.kopo.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativeconsillium.drumsforafrica.kopo.Interfaces.InterfaceLoans;
import com.creativeconsillium.drumsforafrica.kopo.R;

public class FragUnpaidLoansOverdue extends Fragment {

    private InterfaceLoans interLoans;

    private Context coxContext;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            interLoans = (InterfaceLoans) context;
        } catch (ClassCastException ccex) {
            throw new ClassCastException(getActivity() + " MUST Implement InterfaceLoans! ccex: " + ccex);
        }

        this.coxContext = context;

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View vFragUnpaidLoansOverdue =inflater.inflate(R.layout.frag_unpaid_loans_overdue,container,false);

        initializeVariablesAndUIObjects(vFragUnpaidLoansOverdue);

        return vFragUnpaidLoansOverdue;

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
                abActivityActionBar.setTitle(getString(R.string.title_fragment_overdue_loans));
                abActivityActionBar.setDisplayHomeAsUpEnabled(true);
                abActivityActionBar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_action_back));
            }

        }

        CardView cardTala = fragmentLayout.findViewById(R.id.cardUnpaidLoansOverdueTala);
        cardTala.setOnClickListener(clkUnpaidLoansOverdue);

    }


    /**
     * View.OnClickListener interface for handling clicks on views on this Fragment.
     *
     * Implemented in:
     *          - this.initializeVariablesAndUIObjects();
     */
    private View.OnClickListener clkUnpaidLoansOverdue = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

            if (interLoans != null) {
                interLoans.codeToOpenUnpaidLoanDetail();
            }

        }

    };

}