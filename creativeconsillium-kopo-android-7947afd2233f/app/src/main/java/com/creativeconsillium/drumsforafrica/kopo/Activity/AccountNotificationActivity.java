package com.creativeconsillium.drumsforafrica.kopo.Activity;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

import com.creativeconsillium.drumsforafrica.kopo.Misc.KopoConstants;
import com.creativeconsillium.drumsforafrica.kopo.R;

public class AccountNotificationActivity extends AppCompatActivity {

    private CardView cardTestNotifications;

    private SwitchCompat swtDebtLimitAlerts;
    private SwitchCompat swtOverdueLoanAlerts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_notification);

        initializeVariablesAndUIObjects();

    }


    /**
     * Method to declare and initialize class variables and UI Objects referenced in this Activity.
     *
     * Called In:
     *          - (Override) this.onCreate();
     */
    private void initializeVariablesAndUIObjects() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.tbAccountNotification);
        this.setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        swtDebtLimitAlerts = (SwitchCompat) this.findViewById(R.id.swtAccountNotificationDebtLimitAlerts);
        swtOverdueLoanAlerts = (SwitchCompat) this.findViewById(R.id.swtAccountNotificationOverdueLoanAlerts);
        swtDebtLimitAlerts.setOnCheckedChangeListener(occlAccountNotification);
        swtOverdueLoanAlerts.setOnCheckedChangeListener(occlAccountNotification);
        swtDebtLimitAlerts.setChecked(codeToCheckIfDebtLimitAlertsAreEnabledByUser());
        swtOverdueLoanAlerts.setChecked(codeToCheckIfOverdueLoanAlertsAreEnabledByUser());

        cardTestNotifications = (CardView) this.findViewById(R.id.cardAccountNotificationTest);
        cardTestNotifications.setOnClickListener(clkAccountNotifications);

    }

    /**
     * Method to save the current changes made in the Debt Limit Alerts Notification Settings by the user.
     *
     * Called In:
     *          - (Override) this.clkAccountNotifications.onClick();
     *
     * @param debtLimitAlertsEnabled                                    (boolean)
     */
    private void codeToSaveCurrentDebtLimitAlertsNotificationSettings(boolean debtLimitAlertsEnabled) {

        Log.e("AccountNotification", "codeToSaveCurrentDebtLimitAlertsNotificationSettings() - debtLimitAlertsEnabled: " + debtLimitAlertsEnabled);     //  TODO: For Testing ONLY

        SharedPreferences sprefNotificationSettings = this.getSharedPreferences(KopoConstants.sSPREF_APP_NOTIFICATION_SETTINGS, Context.MODE_PRIVATE);
        SharedPreferences.Editor spredNotificationSettings = sprefNotificationSettings.edit();
        spredNotificationSettings.putBoolean(KopoConstants.sSPREFKEY_NOTIFICATION_SETTINGS_DEBT_LIMIT_ALERTS_ENABLED, debtLimitAlertsEnabled);
        spredNotificationSettings.apply();

        //  TODO: In real case scenario, call method to check debt limit and decide whether to fire an alert.

    }

    /**
     * Method to save the current changes made in the Overdue Loan Alerts Notification Settings by the user.
     *
     * Called In:
     *          - (Override) this.clkAccountNotifications.onClick();
     *
     * @param overdueLoanAlertsEnabled                                    (boolean)
     */
    private void codeToSaveCurrentOverdueLoanAlertsNotificationSettings(boolean overdueLoanAlertsEnabled) {

        Log.e("AccountNotification", "codeToSaveCurrentOverdueLoanAlertsNotificationSettings() - overdueLoanAlertsEnabled: " + overdueLoanAlertsEnabled);     //  TODO: For Testing ONLY

        SharedPreferences sprefNotificationSettings = this.getSharedPreferences(KopoConstants.sSPREF_APP_NOTIFICATION_SETTINGS, Context.MODE_PRIVATE);
        SharedPreferences.Editor spredNotificationSettings = sprefNotificationSettings.edit();
        spredNotificationSettings.putBoolean(KopoConstants.sSPREFKEY_NOTIFICATION_SETTINGS_OVERDUE_LOAN_ALERTS_ENABLED, overdueLoanAlertsEnabled);
        spredNotificationSettings.apply();

        //  TODO: In real case scenario, call method to check Overdue Loans and decide whether to fire an alert.

    }

    /**
     * Method to check if Debt Limit Alerts are enabled or not, by the user.
     * It simply returns the boolean value of whether they're enabled or not.
     *
     * Called In:
     *          - (Override) this.clkAccountNotifications.onClick();
     *
     * @return boolDebtLimitAlertsEnabled                                   (boolean)
     */
    private boolean codeToCheckIfDebtLimitAlertsAreEnabledByUser() {

        SharedPreferences sprefNotificationSettings = this.getSharedPreferences(KopoConstants.sSPREF_APP_NOTIFICATION_SETTINGS, Context.MODE_PRIVATE);
        boolean boolDebtLimitAlertsEnabled = sprefNotificationSettings.getBoolean(KopoConstants.sSPREFKEY_NOTIFICATION_SETTINGS_DEBT_LIMIT_ALERTS_ENABLED, true);

        Log.e("AccountNotification", "codeToCheckIfDebtLimitAlertsAreEnabledByUser() - boolDebtLimitAlertsEnabled: " + boolDebtLimitAlertsEnabled);     //  TODO: For Testing ONLY

        return boolDebtLimitAlertsEnabled;
    }

    /**
     * Method to check if Overdue Loan Alerts are enabled or not, by the user.
     * It simply returns the boolean value of whether they're enabled or not.
     *
     * Called In:
     *          - (Override) this.clkAccountNotifications.onClick();
     *
     * @return boolOverdueLoanAlertsEnabled                                   (boolean)
     */
    private boolean codeToCheckIfOverdueLoanAlertsAreEnabledByUser() {

        SharedPreferences sprefNotificationSettings = this.getSharedPreferences(KopoConstants.sSPREF_APP_NOTIFICATION_SETTINGS, Context.MODE_PRIVATE);
        boolean boolOverdueLoanAlertsEnabled = sprefNotificationSettings.getBoolean(KopoConstants.sSPREFKEY_NOTIFICATION_SETTINGS_OVERDUE_LOAN_ALERTS_ENABLED, true);

        Log.e("AccountNotification", "codeToCheckIfOverdueLoanAlertsAreEnabledByUser() - boolOverdueLoanAlertsEnabled: " + boolOverdueLoanAlertsEnabled);     //  TODO: For Testing ONLY

        return boolOverdueLoanAlertsEnabled;
    }

    /**
     * Method to send a Debt Limit Alert Test Notification.
     *
     * Called In:
     *          - (Override) this.clkAccountNotifications.onClick();
     */
    private void codeToSendDebtLimitAlertTestNotification() {

        NotificationCompat.Builder notbldNotificationBuilder = new NotificationCompat.Builder(AccountNotificationActivity.this, KopoConstants.sNOTIFICATIONS_KOPO_CHANNEL_ID);
        notbldNotificationBuilder.setSmallIcon(R.drawable.ic_kopo_notification_shade_black_bg);
        notbldNotificationBuilder.setContentTitle(this.getResources().getString(R.string.nottitleTestDebtLimitAlert));
        notbldNotificationBuilder.setContentText(this.getResources().getString(R.string.notmsgTestDebtLimitAlert));
        notbldNotificationBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(this.getResources().getString(R.string.notmsgTestDebtLimitAlert)));
        notbldNotificationBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notbldNotificationBuilder.setCategory(NotificationCompat.CATEGORY_REMINDER);
        notbldNotificationBuilder.setVisibility(NotificationCompat.VISIBILITY_PRIVATE);
        notbldNotificationBuilder.setAutoCancel(true);

        NotificationManagerCompat notmgrNotificationManager = NotificationManagerCompat.from(AccountNotificationActivity.this);
        notmgrNotificationManager.notify(KopoConstants.iNOTIFICATION_ID_DEBT_LIMIT_ALERT, notbldNotificationBuilder.build());

    }

    /**
     * Method to send an Overdue Loan Alert Test Notification.
     *
     * Called In:
     *          - (Override) this.clkAccountNotifications.onClick();
     */
    private void codeToSendOverdueLoanAlertTestNotification() {

        String sDestinationTag = KopoConstants.sTAG_HOME_LAUNCH_DESTINATION_OVERDUE_LOANS;

        Intent inLaunchHome = new Intent(AccountNotificationActivity.this, HomeActivity.class);
        inLaunchHome.putExtra(KopoConstants.sINKEY_HOME_LAUNCH_DESTINATION, sDestinationTag);
        inLaunchHome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pinLaunchHome = PendingIntent.getActivity(AccountNotificationActivity.this, 0, inLaunchHome, 0);

        NotificationCompat.Builder notbldNotificationBuilder = new NotificationCompat.Builder(AccountNotificationActivity.this, KopoConstants.sNOTIFICATIONS_KOPO_CHANNEL_ID);
        notbldNotificationBuilder.setSmallIcon(R.drawable.ic_kopo_notification_shade_black_bg);
        notbldNotificationBuilder.setContentTitle(this.getResources().getString(R.string.nottitleTestOverdueLoanAlert));
        notbldNotificationBuilder.setContentText(this.getResources().getString(R.string.notmsgTestOverdueLoanAlert));
        notbldNotificationBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(this.getResources().getString(R.string.notmsgTestOverdueLoanAlert)));
        notbldNotificationBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notbldNotificationBuilder.setCategory(NotificationCompat.CATEGORY_REMINDER);
        notbldNotificationBuilder.setVisibility(NotificationCompat.VISIBILITY_PRIVATE);
        notbldNotificationBuilder.setContentIntent(pinLaunchHome);
        notbldNotificationBuilder.setAutoCancel(true);

        NotificationManagerCompat notmgrNotificationManager = NotificationManagerCompat.from(AccountNotificationActivity.this);
        notmgrNotificationManager.notify(KopoConstants.iNOTIFICATION_ID_OVERDUE_LOAN_ALERT, notbldNotificationBuilder.build());

    }

    /**
     * Method to show the user that they need to enable Overdue Loan Alerts in Settings in order to be able to receive respective notifications.
     *
     * Called In:
     *          - (Override) this.clkAccountNotifications.onClick();
     */
    private void codeToReportToTheUserToEnableOverdueLoanNotifications() {

        Snackbar.make(cardTestNotifications, getResources().getString(R.string.snkmsgEnableOverdueLoanAlerts), Snackbar.LENGTH_LONG).show();

    }

    /**
     * Method to show the user that they need to enable Debt Limit Alerts in Settings in order to be able to receive respective notifications.
     *
     * Called In:
     *          - (Override) this.clkAccountNotifications.onClick();
     */
    private void codeToReportToTheUserToEnableDebtLimitNotifications() {

        Snackbar.make(cardTestNotifications, getResources().getString(R.string.snkmsgEnableDebtLimitAlerts), Snackbar.LENGTH_LONG).show();

    }


    /**
     * CompoundButton.OnCheckedChangeListener interface for handling Checked state changes of CompoundButtons in this Activity.
     *
     * Implemented In:
     *          - this.initializeVariablesAndUIObjects();
     */
    private CompoundButton.OnCheckedChangeListener occlAccountNotification = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            switch (buttonView.getId()) {

                case R.id.swtAccountNotificationDebtLimitAlerts:
                    codeToSaveCurrentDebtLimitAlertsNotificationSettings(isChecked);
                    break;

                case R.id.swtAccountNotificationOverdueLoanAlerts:
                    codeToSaveCurrentOverdueLoanAlertsNotificationSettings(isChecked);
                    break;

            }

        }

    };

    /**
     * View.OnClickListener interface for handling clicks on Views in this Activity.
     *
     * Implemented In:
     *          - this.initializeVariablesAndUIObjects();
     */
    private View.OnClickListener clkAccountNotifications = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.btnAccountNotificationSaveSettings:

                    codeToSaveCurrentDebtLimitAlertsNotificationSettings(swtDebtLimitAlerts.isChecked());
                    codeToSaveCurrentOverdueLoanAlertsNotificationSettings(swtOverdueLoanAlerts.isChecked());

                    break;

                case R.id.cardAccountNotificationTest:

                    if (codeToCheckIfOverdueLoanAlertsAreEnabledByUser()) {
                        codeToSendOverdueLoanAlertTestNotification();
                    } else {
                        codeToReportToTheUserToEnableOverdueLoanNotifications();
                    }

                    if (codeToCheckIfDebtLimitAlertsAreEnabledByUser()) {
                        codeToSendDebtLimitAlertTestNotification();
                    } else {
                        codeToReportToTheUserToEnableDebtLimitNotifications();
                    }

                    break;

            }

        }

    };

}
