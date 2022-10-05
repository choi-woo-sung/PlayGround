package com.example.playground.overlap

import android.os.SystemClock
import android.view.View
import com.jakewharton.rxbinding4.view.clicks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.actor
import java.util.concurrent.TimeUnit

/**
 * 기존방식
 *
 * @param action
 */
fun View.setSingleListener(
    action: (View) -> Unit,
) {
    val oneClick = OnSingleClickListener {
        action(it)
    }
    setOnClickListener(oneClick)
}

/**
 * Rx방식
 *
 * @param activity
 * @param intervalSecond
 * @param action
 */
fun View.setThrottleFirstClickListener(
    activity: BaseActivity,
    intervalSecond: Long = 1,
    action: (View) -> Unit,
) {

    val disposable = clicks()
        .throttleFirst(intervalSecond, TimeUnit.SECONDS)
        .subscribe {
            action.invoke(this)
        }
    activity.addDisposable(disposable)
}



private fun View.onActorClick(action: suspend (View) -> Unit) {
    // launch one actor
    val event = GlobalScope.actor<View>(Dispatchers.Main) {
        for (event in channel) action(event)
    }

    setOnClickListener {
        event.offer(it)
    }
}



class OnSingleClickListener(
    private var interval: Int = 600,
    private var onSingleClick: (View) -> Unit,
) : View.OnClickListener {

    private var lastClickTime: Long = 0

    override fun onClick(v: View) {
        val elapsedRealtime = SystemClock.elapsedRealtime()
        if ((elapsedRealtime - lastClickTime) < interval) {
            return
        }
        lastClickTime = elapsedRealtime
        onSingleClick(v)
    }
}

