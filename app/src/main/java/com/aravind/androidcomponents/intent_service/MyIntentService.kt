package com.aravind.androidcomponents.intent_service

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("name") {


    init {
        instance = this
    }

    companion object{
        var isRunning : Boolean = false
        private lateinit var instance : MyIntentService

        fun stopService(){
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(p0: Intent?) {
        try {
            isRunning = true
            while (isRunning){
                Thread.sleep(1000)
                Log.d("MyIntentService","Service is running...")
            }
        }catch (e:InterruptedException){
            print(e.localizedMessage)
        }
    }
}