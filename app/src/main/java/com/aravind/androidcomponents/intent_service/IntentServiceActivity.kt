package com.aravind.androidcomponents.intent_service

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.aravind.androidcomponents.R
import com.aravind.androidcomponents.databinding.ActivityIntentServiceBinding

class IntentServiceActivity : AppCompatActivity() {

    lateinit var binding : ActivityIntentServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intent_service)

        binding.startBtn.setOnClickListener {
            Intent(this,MyIntentService::class.java).also {
                intent -> startService(intent)
                binding.infoTv.text = "Service running"
            }
        }


        binding.stopBtn.setOnClickListener {
            MyIntentService.isRunning = false
            MyIntentService.stopService()
            binding.infoTv.text = "Service stopped"
        }
    }
}