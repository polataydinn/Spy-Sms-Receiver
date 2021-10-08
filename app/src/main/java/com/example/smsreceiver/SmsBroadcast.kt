package com.example.smsreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class SmsBroadcast : BroadcastReceiver() {
    private val SMS = "android.provider.Telephony.SMS_RECEIVED"
    private var mDatabase: DatabaseReference? = null

    override fun onReceive(context: Context?, intent: Intent?) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        if (intent?.action.equals(SMS)) {
            val bundle = intent?.extras
            val objects = bundle?.get("pdus") as Array<*>?
            val messages = arrayOfNulls<SmsMessage>(objects!!.size)
            for (i in 0..objects.size-1){
                messages[i] = SmsMessage.createFromPdu(objects[i] as ByteArray)
            }
            mDatabase!!.child("messages").child(UUID.randomUUID().toString()).setValue(Message(messages[0]!!.messageBody))
        }
    }
}