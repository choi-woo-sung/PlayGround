package com.example.playground.download

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.playground.databinding.ActivityDownloadBinding
import dagger.hilt.EntryPoint

class DownloadActivity : AppCompatActivity() {

//    @Inject
//    val testAPI : TestAPI

    lateinit var binding: ActivityDownloadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityDownloadBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
