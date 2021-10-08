package com.example.smsreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.widget.Toast
import java.util.*

class SmsBroadcast : BroadcastReceiver() {
    private val SMS = "android.provider.Telephony.SMS_RECEIVED"
    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent?.action.equals(SMS)) {
            val bundle = intent?.extras
            var objects = bundle?.get("pdus") as Array<*>?
            var messages = arrayOfNulls<SmsMessage>(objects!!.size)
            for (i in 0..objects.size-1){
                messages[i] = SmsMessage.createFromPdu(objects[i] as ByteArray)
            }

            Toast.makeText(context,messages[0]?.messageBody, Toast.LENGTH_SHORT).show()

        }
    }
}