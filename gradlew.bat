package com.example.callrecorder;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class IncomingReceiver extends BroadcastReceiver {
    @SuppressLint("LongLogTag")
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("IncomingBroadcastReceiver: onReceive: ", "flag1");

        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        Log.d("IncomingBroadcastReceiver: onReceive: ", state);
        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)
                || state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {

            Log.d("Ringing", "Phone is ringing");

            Intent i = new Intent(context, IncomingCallActivity.class);
            i.putExtras(intent);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            Wait.oneSec();
            context.startActivity(i);

        }


    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           