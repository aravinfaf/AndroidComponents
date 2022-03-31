package com.aravind.androidcomponents.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    val TAG = "MyService"
    override fun onBind(p0: Intent?): IBinder?  = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("Data")
        dataString?.let {
            Log.d(TAG,dataString)
        }

        Thread {
            while (true) {
            }
        }
        return START_STICKY
    }

    // START_NOT_STICKY -> If system kills the service not possible to recreate the resource
    // START_STICKY -> If system kills the service possible to recreate the resource
    // START_REDELIVER_INTENT -> If system kills the service re-deliver the previous intent
}