package com.example.smsreceiver

import android.os.Bundle
import android.telephony.SmsMessage

class Test {
    var bundle = Bundle()
    var objects = bundle["pdus"] as Array<*>?
    var messages = arrayOfNulls<SmsMessage>(
        objects!!.size
    )
}