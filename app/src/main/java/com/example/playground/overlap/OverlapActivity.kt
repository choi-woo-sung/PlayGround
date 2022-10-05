package com.example.playground.overlap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.playground.databinding.ActivityOverlapBinding
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

/**
 * 중복 리스너를 막는 챕터
 *
 */
class OverlapActivity : BaseActivity() {
    private lateinit var binding: ActivityOverlapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOverlapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListener()
    }

    private fun setOnClickListener() {

        binding.button.setSingleListener {
            Toast.makeText(this, "들어왓습니다" ,Toast.LENGTH_SHORT).show()
        }

        binding.buttonRx.setThrottleFirstClickListener(this){
            Toast.makeText(this, "들어왓습니다" ,Toast.LENGTH_SHORT).show()
        }

        binding.buttonActor

        binding.buttonFlow


    }

}

abstract class BaseActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }


}