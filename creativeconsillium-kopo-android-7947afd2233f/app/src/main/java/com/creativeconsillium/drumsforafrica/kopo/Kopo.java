package com.creativeconsillium.drumsforafrica.kopo;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.res.Configuration;
import android.os.Build;

import com.creativeconsillium.drumsforafrica.kopo.Misc.KopoConstants;

/**
 * Application class for this App.
 *
 * Created by Edward N. Ndukui,
 * on Monday, 24th/June/2019,
 * at 06:01PM.
 */
public class Kopo extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        AppCenter.start(Kopo.this, getResources().getString(R.string.sAppCenterAppSecret), Analytics.class, Crashes.class, Distribute.class);

        codeToCreateAKopoNotificationChannel();

    }


    /**
     * Method to create Kopo Notification Channel for Kopo Notifications.
     *
     * Called In:
     *          - (Override) this.onCreate();
     */
    private void codeToCreateAKopoNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence chsChannelName = KopoConstants.sNOTIFICATIONS_KOPO_CHANNEL_NAME;
            String sChannelDescription = KopoConstants.sNOTIFICATION_KOPO_CHANNEL_DESCRIPTION;
            int iChannelImportance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notchKopoNotificationChannel = new NotificationChannel(KopoConstants.sNOTIFICATIONS_KOPO_CHANNEL_ID, chsChannelName, iChannelImportance);
            notchKopoNotificationChannel.setDescription(sChannelDescription);

            NotificationManager notmgrNotificationManager = getSystemService(NotificationManager.class);
            notmgrNotificationManager.createNotificationChannel(notchKopoNotificationChannel);

        }

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
