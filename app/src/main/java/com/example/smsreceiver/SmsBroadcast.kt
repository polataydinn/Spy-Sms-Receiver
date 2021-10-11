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

    }
}