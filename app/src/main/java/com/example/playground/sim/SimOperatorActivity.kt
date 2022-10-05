package com.example.playground.sim

import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.playground.databinding.ActivitySimOperatorBinding

class SimOperatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimOperatorBinding
    lateinit var telephonyManager: TelephonyManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySimOperatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            binding.textView.text = "고민이에요... "
        }

        telephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager

        Toast.makeText(this, telephonyManager.networkOperatorName, Toast.LENGTH_SHORT).show()
    }
}
