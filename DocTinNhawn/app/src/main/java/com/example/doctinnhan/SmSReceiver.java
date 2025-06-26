package com.example.doctinnhan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        processSMS(context,intent);
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void processSMS(Context context, Intent intent) {
        Bundle mybundle = intent.getExtras();
        String message = "";
        String body = "";
        String address = "";
        if (mybundle != null){
            Object[] mysms = (Object[]) mybundle.get("pdus");
            for (int i = 0 ;i < mysms.length;i++){
                SmsMessage sms = SmsMessage.createFromPdu((byte[]) mysms[i]);

                body += sms.getMessageBody(); // lay noi dug tin nhan
                address = sms.getOriginatingAddress();


            }
            message = "co 1 tin nhan moi tu" + address+"\n"+" "+body+"vua gui den";
            Toast.makeText(context,message,Toast.LENGTH_LONG).show();

        }
    }
}