package com.aravind.androidcomponents.service

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.aravind.androidcomponents.R
import com.aravind.androidcomponents.databinding.ActivityIntentServiceBinding
import com.aravind.androidcomponents.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {

    lateinit var binding : ActivityServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_service)

        binding.startBtn.setOnClickListener {
            Intent(this,MyService::class.java).also {
               startService(it)
                binding.infoTv.text = "Service running"
            }
        }


        binding.stopBtn.setOnClickListener {
            Intent(this,MyService::class.java).also {
                stopService(it)
                binding.infoTv.text = "Service stopping"
            }
        }

        binding.sendDataBtn.setOnClickListener {
            Intent(this,MyService::class.java).also {
                it.putExtra("Data",binding.editText.text.toString())
                startService(it)
            }
            binding.infoTv.text = "Sending Data"
        }
    }
}