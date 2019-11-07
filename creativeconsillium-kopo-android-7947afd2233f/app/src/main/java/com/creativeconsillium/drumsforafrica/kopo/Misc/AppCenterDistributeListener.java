package com.creativeconsillium.drumsforafrica.kopo.Misc;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;

import com.creativeconsillium.drumsforafrica.kopo.R;
import com.microsoft.appcenter.distribute.Distribute;
import com.microsoft.appcenter.distribute.DistributeListener;
import com.microsoft.appcenter.distribute.ReleaseDetails;
import com.microsoft.appcenter.distribute.UpdateAction;

/**
 * Class to implement interface that handles Distribute events from Microsoft AppCenter.
 *
 * Created by Edward N. Ndukui,
 * on Thursday, 27th/June/2019,
 * at 07:44PM.
 */
public class AppCenterDistributeListener implements DistributeListener {

    private Context coxContext;


    public AppCenterDistributeListener(Context context) {
        this.coxContext = context;
    }


    @Override
    public boolean onReleaseAvailable(Activity activity, ReleaseDetails releaseDetails) {

        String sVersionName = releaseDetails.getShortVersion();
        String sReleaseNotes = releaseDetails.getReleaseNotes();

        Uri uriReleaseNotesUrl = releaseDetails.getReleaseNotesUrl();

        int iVersionCode = releaseDetails.getVersion();

        String sDialogTitle = coxContext.getResources().getString(R.string.sKopoUpdate) + " - " + iVersionCode;

        AlertDialog.Builder adbldUpdate = new AlertDialog.Builder(coxContext);
        adbldUpdate.setTitle(sDialogTitle);
        adbldUpdate.setMessage(sReleaseNotes);
        adbldUpdate.setCancelable(false);
        adbldUpdate.setPositiveButton(com.microsoft.appcenter.distribute.R.string.appcenter_distribute_update_dialog_download, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Distribute.notifyUpdateAction(UpdateAction.UPDATE);
            }

        });

        if (!releaseDetails.isMandatoryUpdate()) {

            adbldUpdate.setNegativeButton(com.microsoft.appcenter.distribute.R.string.appcenter_distribute_update_dialog_postpone, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Distribute.notifyUpdateAction(UpdateAction.POSTPONE);
                }

            });

        }

        AlertDialog adgUpdate = adbldUpdate.create();
        adgUpdate.show();

        return true;
    }

}
