package com.creativeconsillium.drumsforafrica.kopo.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativeconsillium.drumsforafrica.kopo.Interfaces.InterfaceHome;
import com.creativeconsillium.drumsforafrica.kopo.Misc.KopoConstants;
import com.creativeconsillium.drumsforafrica.kopo.R;

/**
 * Fragment class for Home.
 *
 * Created by Edward N. Ndukui,
 * on Saturday, 22nd/June/2019,
 * at 10:35AM.
 */
public class FragHome extends Fragment {

    private InterfaceHome interHome;



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            interHome = (InterfaceHome) context;
        } catch (ClassCastException ccex) {
            throw new ClassCastException(getActivity() + " MUST Implement InterfaceHome! ccex: " + ccex);
        }

        try {
            interHome = (InterfaceHome) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving clicked Overdue card ID. Please try again");
        }

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View vFragHome = inflater.inflate(R.layout.frag_home, container, false);

        initializeVariablesAndUIObjects(vFragHome);

        return vFragHome;
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
                abActivityActionBar.setTitle(getString(R.string.title_fragment_home));
                abActivityActionBar.setDisplayHomeAsUpEnabled(false);
            }

        }

        CardView cardUnpaidLoans = (CardView) fragmentLayout.findViewById(R.id.cardHomeUnpaidLoans);
        CardView cardOverdueLoans = (CardView) fragmentLayout.findViewById(R.id.cardHomeOverdueLoans);
        CardView cardPaidLoans = (CardView) fragmentLayout.findViewById(R.id.cardHomePaidLoans);
        CardView cardLoansReport = (CardView) fragmentLayout.findViewById(R.id.cardHomeLoansReport);
        CardView cardInviteAFriend = (CardView) fragmentLayout.findViewById(R.id.cardHomeInviteAFriend);
        cardUnpaidLoans.setOnClickListener(clkHome);
        cardOverdueLoans.setOnClickListener(clkHome);
        cardPaidLoans.setOnClickListener(clkHome);
        cardLoansReport.setOnClickListener(clkHome);
        cardInviteAFriend.setOnClickListener(clkHome);

    }


    /**
     * View.OnClickListener interface for handlicg clicks on Views on this Fragment.
     *
     * Implemented in:
     *          - this.initializeVariablesAndUIObjects();
     */
    private View.OnClickListener clkHome = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.cardHomeUnpaidLoans:

                    if (interHome != null) {
                        interHome.codeToOpenLoans(KopoConstants.sTAG_LOANS_CATEGORY_UNPAID);
                    }

                    break;

                case R.id.cardHomeOverdueLoans:

                    if (interHome != null) {
                        interHome.codeToOpenUnpaidOverdueLoans();
                    }

                    break;

                case R.id.cardHomePaidLoans:

                    if (interHome != null) {
                        interHome.codeToOpenLoans(KopoConstants.sTAG_LOANS_CATEGORY_PAID);
                    }

                    break;

                case R.id.cardHomeLoansReport:

                    if (interHome != null) {
                        interHome.codeToOpenLoanReports();
                    }

                    break;

                case R.id.cardHomeInviteAFriend:

                    if (interHome != null) {
                        interHome.codeToOpenInviteAFriend();
                    }

                    break;

            }

        }

    };




}
