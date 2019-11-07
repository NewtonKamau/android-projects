package com.creativeconsillium.drumsforafrica.kopo.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.creativeconsillium.drumsforafrica.kopo.Fragments.FragHome;
import com.creativeconsillium.drumsforafrica.kopo.Fragments.FragLoans;
import com.creativeconsillium.drumsforafrica.kopo.Fragments.FragPaidLoanDetail;
import com.creativeconsillium.drumsforafrica.kopo.Fragments.FragReports;
import com.creativeconsillium.drumsforafrica.kopo.Fragments.FragUnpaidLoanDetail;
import com.creativeconsillium.drumsforafrica.kopo.Fragments.FragUnpaidLoansOverdue;
import com.creativeconsillium.drumsforafrica.kopo.Interfaces.InterfaceHome;
import com.creativeconsillium.drumsforafrica.kopo.Interfaces.InterfaceLoans;
import com.creativeconsillium.drumsforafrica.kopo.Misc.AppCenterDistributeListener;
import com.creativeconsillium.drumsforafrica.kopo.Misc.KopoConstants;
import com.creativeconsillium.drumsforafrica.kopo.R;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.distribute.Distribute;

public class HomeActivity extends AppCompatActivity implements InterfaceHome, InterfaceLoans {

    private BottomNavigationView bottomNavigationView;

    private FragmentTransaction ftHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Distribute.setEnabledForDebuggableBuild(true);
        Distribute.setListener(new AppCenterDistributeListener(HomeActivity.this));
        AppCenter.start(getApplication(), getResources().getString(R.string.sAppCenterAppSecret), Analytics.class, Crashes.class, Distribute.class);

        initializeVariablesAndUIObjects();

    }


    /**
     * Method to declare and initialize class variables in this Activity.
     * It also calls the method to update the Bottom Navigation View to reflect the current screen.
     * It also calls the method to set up Home Fragment as the initial Fragment.
     * It also calls the method to check if the launching intent requests another destination in the App.
     *
     * Called In:
     *          - (Override) this.onCreate();
     */
    private void initializeVariablesAndUIObjects() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            this.setSupportActionBar(toolbar);
        }

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.action_loans:

                        codeToSetUpLoansFragment(KopoConstants.sTAG_LOANS_CATEGORY_UNPAID);

                        break;

                    case R.id.action_home:

                        codeToSetUpHomeFragmentAsInitialFragment();

                        break;

                    case R.id.action_reports:

                        codeToSetUpReportsFragment();

                        break;
                }

                return true;
            }

        });

        codeToUpdateBottomNavigationViewToReflectCurrentScreen(KopoConstants.sTAG_BOTTOM_NAVIGATION_HOME);

        codeToSetUpHomeFragmentAsInitialFragment();

        codeToCheckIfThereIsAnotherDestinationRequestedByTheLaunchingIntent();

    }

    /**
     * Method to check and act if there's another destination in the app requested by the intent launching this Activity;
     * A destination other than Home.
     *
     * Called In:
     *          - this.initializeVariablesAndUIObjects();
     */
    private void codeToCheckIfThereIsAnotherDestinationRequestedByTheLaunchingIntent() {

        Intent inHomeLaunchIntent = this.getIntent();
        if ((inHomeLaunchIntent != null) && (inHomeLaunchIntent.hasExtra(KopoConstants.sINKEY_HOME_LAUNCH_DESTINATION))) {

            String sDestinationTag = inHomeLaunchIntent.getStringExtra(KopoConstants.sINKEY_HOME_LAUNCH_DESTINATION);

            if (sDestinationTag.equals(KopoConstants.sTAG_HOME_LAUNCH_DESTINATION_OVERDUE_LOANS)) {
                codeToSetUpUnpaidOverdueLoansFragment();
            } else if (sDestinationTag.equals(KopoConstants.sTAG_HOME_LAUNCH_DESTINATION_UNPAID_LOANS)) {
                codeToSetUpLoansFragment(KopoConstants.sTAG_LOANS_CATEGORY_UNPAID);
            }

        }

    }

    /**
     * Method to set up Fragment Home as the first Fragment on this Activity.
     *
     * Called In:
     *          - this.initializeVariablesAndUIObjects();
     */
    private void codeToPassHomeOverdueCardToLoansFragment() {

        ftHome = this.getSupportFragmentManager().beginTransaction();
        ftHome.add(R.id.conslayHomeFragContainer, new FragHome());
        ftHome.commitAllowingStateLoss();

    }

    /**
     * Method to set up Fragment Home as the first Fragment on this Activity.
     *
     * Called In:
     *          - this.initializeVariablesAndUIObjects();
     */
    private void codeToSetUpHomeFragmentAsInitialFragment() {

        ftHome = this.getSupportFragmentManager().beginTransaction();
        ftHome.replace(R.id.conslayHomeFragContainer, new FragHome(), KopoConstants.sTAG_FRAGMENT_HOME);
        ftHome.commitAllowingStateLoss();

    }

    /**
     * Method to set up Fragment Home on this Activity.
     *
     * Called In:
     *          - this.initializeVariablesAndUIObjects().bottomNavigationView.onNavigationItemSelected();
     */
    private void codeToSetUpHomeFragment() {

        ftHome = this.getSupportFragmentManager().beginTransaction();
        ftHome.replace(R.id.conslayHomeFragContainer, new FragHome(), KopoConstants.sTAG_FRAGMENT_HOME);
        ftHome.addToBackStack(KopoConstants.sTAG_FRAGMENT_HOME);
        ftHome.commitAllowingStateLoss();

    }

    /**
     * Method to set up Fragment Loans on this Activity.
     * It takes in a parameter that specifies which loans category to be set up, i.e. Paid or Unpaid.
     *
     * Called In:
     *          - this.initializeVariablesAndUIObjects().bottomNavigationView.onNavigationItemSelected();
     *
     * @param loansCategoryToOpen                                     (String)
     */
    private void codeToSetUpLoansFragment(String loansCategoryToOpen) {

        Bundle bunFragLoansArguments = new Bundle();
        bunFragLoansArguments.putString(KopoConstants.sBUNKEY_LOANS_CATEGORY_TO_OPEN, loansCategoryToOpen);

        FragLoans clsFragLoans = new FragLoans();
        clsFragLoans.setArguments(bunFragLoansArguments);

        ftHome = this.getSupportFragmentManager().beginTransaction();
        ftHome.replace(R.id.conslayHomeFragContainer, clsFragLoans, KopoConstants.sTAG_FRAGMENT_LOANS);
        ftHome.addToBackStack(KopoConstants.sTAG_FRAGMENT_LOANS);
        ftHome.commitAllowingStateLoss();

    }

    /**
     * Method to set up Fragment Unpaid Overdue Loans on this Activity.
     *
     * Called In:
     *          - this.InterfaceHome.codeToOpenUnpaidOverdueLoans();
     */
    private void codeToSetUpUnpaidOverdueLoansFragment() {

        ftHome = this.getSupportFragmentManager().beginTransaction();
        ftHome.replace(R.id.conslayHomeFragContainer, new FragUnpaidLoansOverdue(), KopoConstants.sTAG_FRAGMENT_UNPAID_OVERDUE_LOANS);
        ftHome.addToBackStack(KopoConstants.sTAG_FRAGMENT_UNPAID_OVERDUE_LOANS);
        ftHome.commitAllowingStateLoss();

    }

    /**
     * Method to set up Fragment Reports on this Activity.
     *
     * Called In:
     *          - this.initializeVariablesAndUIObjects().bottomNavigationView.onNavigationItemSelected();
     */
    private void codeToSetUpReportsFragment() {

        ftHome = this.getSupportFragmentManager().beginTransaction();
        ftHome.replace(R.id.conslayHomeFragContainer, new FragReports(), KopoConstants.sTAG_FRAGMENT_REPORTS);
        ftHome.addToBackStack(KopoConstants.sTAG_FRAGMENT_REPORTS);
        ftHome.commitAllowingStateLoss();

    }

    /**
     * Method to set up Fragment Unpaid Loan Detail on this Activity.
     *
     * Called In:
     *          - (Override) this.InterfaceLoans.codeToOpenUnpaidLoanDetail();
     */
    private void codeToSetUpUnpaidLoanDetailFragment() {

        ftHome = this.getSupportFragmentManager().beginTransaction();
        ftHome.replace(R.id.conslayHomeFragContainer, new FragUnpaidLoanDetail(), KopoConstants.sTAG_FRAGMENT_UNPAID_LOAN_DETAIL);
        ftHome.addToBackStack(KopoConstants.sTAG_FRAGMENT_UNPAID_LOAN_DETAIL);
        ftHome.commitAllowingStateLoss();

    }

    /**
     * Method to set up Fragment Paid Loan Detail on this Activity.
     *
     * Called In:
     *          - (Override) this.InterfaceLoans.codeToOpenPaidLoanDetail();
     */
    private void codeToSetUpPaidLoanDetailFragment() {

        ftHome = this.getSupportFragmentManager().beginTransaction();
        ftHome.replace(R.id.conslayHomeFragContainer, new FragPaidLoanDetail(), KopoConstants.sTAG_FRAGMENT_PAID_LOAN_DETAIL);
        ftHome.addToBackStack(KopoConstants.sTAG_FRAGMENT_PAID_LOAN_DETAIL);
        ftHome.commitAllowingStateLoss();

    }

    /**
     * Method to start Account Activity.
     *
     * Called In:
     *          - (Override) this.onOptionsItemSelected();
     */
    private void codeToStartAccountActivity() {

        Intent inStartAccountActivity = new Intent(HomeActivity.this, AccountActivity.class);
        this.startActivity(inStartAccountActivity);

    }

    /**
     * Method to start Pay Loan Activity.
     *
     * Called In:
     *          - (Override) this.InterfaceHome.codeToOpenLoanPayment();
     */
    private void codeToStartPayLoanActivity() {

        Intent inStartPayLoanActivity = new Intent(HomeActivity.this, LoansPayLoanActivity.class);
        this.startActivity(inStartPayLoanActivity);

    }

    /**
     * Method to start Invite a Friend Activity.
     *
     * Called In:
     *          - (Override) this.InterfaceHome.codeToOpenInviteAFriend();
     */
    private void codeToStartInviteFriendActivity() {

        Intent inStartInviteFriendActivity = new Intent(HomeActivity.this, InviteFriendActivity.class);
        this.startActivity(inStartInviteFriendActivity);

    }

    /**
     * Method to update the items of the Bottom Navigation View based on which screen the user is on currently.
     *
     * Called In:
     *          - this.initializeVariablesAndUIObjects();
     *          - (Override) this.InterfaceHome.codeToOpenLoans();
     *          - (Override) this.InterfaceHome.codeToOpenLoanReports();
     *
     * @param currentScreenTag                                          (String)
     */
    private void codeToUpdateBottomNavigationViewToReflectCurrentScreen(@NonNull String currentScreenTag) {

        switch (currentScreenTag) {

            case KopoConstants.sTAG_BOTTOM_NAVIGATION_HOME:
                bottomNavigationView.setSelectedItemId(R.id.action_home);
                break;

            case KopoConstants.sTAG_BOTTOM_NAVIGATION_LOANS:
                bottomNavigationView.setSelectedItemId(R.id.action_loans);
                break;

            case KopoConstants.sTAG_BOTTOM_NAVIGATION_REPORTS:
                bottomNavigationView.setSelectedItemId(R.id.action_reports);
                break;

            default:
                bottomNavigationView.setSelectedItemId(R.id.action_home);
                break;

        }

    }

    /**
     * Method to update the items of the Bottom Navigation View based on which screen the user is on currently, after pressing the Back Button.
     *
     * Called In:
     *          - (Override) this.onBackPressed();
     *
     * @param backStackEntry                                          (FragmentManager.BackStackEntry)
     */
    private void codeToUpdateBottomNavigationViewToReflectCurrentScreenOnBackPressed(@Nullable FragmentManager.BackStackEntry backStackEntry) {

        Log.e("HomeActivity", "codeToUpdateBottomNavigationViewToReflectCurrentScreenOnBackPressed() - CALLED!");   //  TODO: For Testing ONLY

        if (backStackEntry != null) {

            String sCurrentFragmentTag = backStackEntry.getName();

            Log.e("HomeActivity", "codeToUpdateBottomNavigationViewToReflectCurrentScreenOnBackPressed() - sCurrentFragmentTag: " + sCurrentFragmentTag);   //  TODO: For Testing ONLY

            if (sCurrentFragmentTag != null) {

                switch (sCurrentFragmentTag) {

                    case KopoConstants.sTAG_FRAGMENT_HOME:
                        Log.e("HomeActivity", "codeToUpdateBottomNavigationViewToReflectCurrentScreenOnBackPressed() - Home Fragment!");   //  TODO: For Testing ONLY
                        codeToUpdateBottomNavigationViewToReflectCurrentScreen(KopoConstants.sTAG_BOTTOM_NAVIGATION_HOME);
                        break;

                    case KopoConstants.sTAG_FRAGMENT_LOANS:
                        Log.e("HomeActivity", "codeToUpdateBottomNavigationViewToReflectCurrentScreenOnBackPressed() - Loans Fragment!");   //  TODO: For Testing ONLY
                        codeToUpdateBottomNavigationViewToReflectCurrentScreen(KopoConstants.sTAG_BOTTOM_NAVIGATION_LOANS);
                        break;

                    case KopoConstants.sTAG_FRAGMENT_REPORTS:
                        Log.e("HomeActivity", "codeToUpdateBottomNavigationViewToReflectCurrentScreenOnBackPressed() - Reports Fragment!");   //  TODO: For Testing ONLY
                        codeToUpdateBottomNavigationViewToReflectCurrentScreen(KopoConstants.sTAG_BOTTOM_NAVIGATION_REPORTS);
                        break;

                    default:
                        codeToUpdateBottomNavigationViewToReflectCurrentScreen(KopoConstants.sTAG_BOTTOM_NAVIGATION_HOME);
                        break;

                }

            }

        }

    }

    /**
     * This method shows an AlertDialog that asks the user to confirm if they want to Exit the App.
     *
     * Called In:
     *          - (Override) this.onBackPressed();
     */
    private void codeToShowAppExitConfirmationDialog() {

        AlertDialog.Builder adbldAppExitConfirmation = new AlertDialog.Builder(HomeActivity.this);
        adbldAppExitConfirmation.setIcon(getDrawable(android.R.drawable.ic_dialog_alert));
        adbldAppExitConfirmation.setTitle(getString(R.string.dgtitleConfirmExit));
        adbldAppExitConfirmation.setMessage(getString(R.string.dgmsgConfirmExit));
        adbldAppExitConfirmation.setCancelable(false);
        adbldAppExitConfirmation.setPositiveButton(getString(R.string.dgbtnYesExit), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                HomeActivity.this.finish();
            }

        });
        adbldAppExitConfirmation.setNegativeButton(getString(R.string.dgbtnNo), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }

        });

        AlertDialog adgAppExitConfirmation = adbldAppExitConfirmation.create();
        adgAppExitConfirmation.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.actionAccount) {

            codeToStartAccountActivity();

            return true;
        } else if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {

        FragmentManager fmHomeFragmentManager = this.getSupportFragmentManager();
        if (fmHomeFragmentManager.getBackStackEntryCount() > 1) {

            fmHomeFragmentManager.popBackStack();
            super.onBackPressed();


        } else if (fmHomeFragmentManager.getBackStackEntryCount() == 1) {

            super.onBackPressed();

        } else {
            codeToShowAppExitConfirmationDialog();
        }

    }


    // [START]: InterfaceHome

    @Override
    public void codeToOpenLoans(String loansCategoryToOpen) {
        codeToUpdateBottomNavigationViewToReflectCurrentScreen(KopoConstants.sTAG_BOTTOM_NAVIGATION_LOANS);
        codeToSetUpLoansFragment(loansCategoryToOpen);
    }

    @Override
    public void codeToOpenUnpaidOverdueLoans() {
        codeToUpdateBottomNavigationViewToReflectCurrentScreen(KopoConstants.sTAG_BOTTOM_NAVIGATION_LOANS);
        codeToSetUpUnpaidOverdueLoansFragment();
    }

    @Override
    public void codeToOpenLoanReports() {
        codeToUpdateBottomNavigationViewToReflectCurrentScreen(KopoConstants.sTAG_BOTTOM_NAVIGATION_REPORTS);
        codeToSetUpReportsFragment();
    }

    @Override
    public void codeToOpenLoanPayment() {
        codeToStartPayLoanActivity();
    }

    @Override
    public void codeToOpenInviteAFriend() {
        codeToStartInviteFriendActivity();
    }

    // [END]: InterfaceHome


    // [START]: InterfaceLoans

    @Override
    public void codeToOpenUnpaidLoanDetail() {
        codeToSetUpUnpaidLoanDetailFragment();
    }

    @Override
    public void codeToOpenPaidLoanDetail() {
        codeToSetUpPaidLoanDetailFragment();
    }

    // [END]: InterfaceLoans


}
