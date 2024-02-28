package com.example.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager


class BatteryBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent?.action == Intent.ACTION_BATTERY_CHANGED) {
            val isCharging = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
            val batteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)


            println("Is Charging $isCharging")
            println("Battery level $batteryLevel")
        }
    }
}

