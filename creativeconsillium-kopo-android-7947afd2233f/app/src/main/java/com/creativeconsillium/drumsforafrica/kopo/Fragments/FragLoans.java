package com.creativeconsillium.drumsforafrica.kopo.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativeconsillium.drumsforafrica.kopo.Adapter.AdapterVPRLoans;
import com.creativeconsillium.drumsforafrica.kopo.Misc.KopoConstants;
import com.creativeconsillium.drumsforafrica.kopo.R;

/**
 * Fragment class for Loans.
 *
 * Created by Edward N. Ndukui,
 * on Saturday, 22nd/June/2019,
 * at 11:27AM.
 */
public class FragLoans extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View vFragLoans = inflater.inflate(R.layout.frag_loans, container, false);

        initializeVariablesAndUIObjects(vFragLoans);

        return vFragLoans;
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
                abActivityActionBar.setTitle(getString(R.string.title_fragment_loans));
                abActivityActionBar.setDisplayHomeAsUpEnabled(true);
                abActivityActionBar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_action_back));
            }

        }

        // Add tabs
        TabLayout tabLayout = (TabLayout) fragmentLayout.findViewById(R.id.tabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager vprLoans = (ViewPager) fragmentLayout.findViewById(R.id.pager);
        vprLoans.setAdapter(new AdapterVPRLoans(getChildFragmentManager(), tabLayout.getTabCount()));
        vprLoans.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vprLoans.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}

        });

        Bundle bunArguments = this.getArguments();
        if (bunArguments != null) {

            String sLoansCategoryToOpen = bunArguments.getString(KopoConstants.sBUNKEY_LOANS_CATEGORY_TO_OPEN);
            if (sLoansCategoryToOpen != null) {

                if (sLoansCategoryToOpen.equals(KopoConstants.sTAG_LOANS_CATEGORY_UNPAID)) {
                    vprLoans.setCurrentItem(0, true);
                } else if (sLoansCategoryToOpen.equals(KopoConstants.sTAG_LOANS_CATEGORY_PAID)) {
                    vprLoans.setCurrentItem(1, true);
                }

            }
        }

    }

}
