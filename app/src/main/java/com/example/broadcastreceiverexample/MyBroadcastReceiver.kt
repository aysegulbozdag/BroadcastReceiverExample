package com.example.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // Yayın alındığında bu metod çağrılır
        val action = intent.action
        if (action == "com.example.custom_action") {
            val message = intent.getStringExtra("message")
            println("Broadcast alındı: $message")
        }
    }
}