package com.example.playground.semaphore

import android.os.SystemClock
import android.view.View
import com.jakewharton.rxbinding4.view.clicks
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor
import java.util.concurrent.TimeUnit

fun <T, R> Iterable<T>.map(
    dispatcher: CoroutineDispatcher,
    transform: (T) -> R
): List<R> = runBlocking {
    map { item -> async(dispatcher) { transform(item) } }.awaitAll()
}

//fun doSomething(users: List<User>) {
//    //프로그램이 매우 무거울경우, 모든 코어를 사용항하는데 바쁘고, 다른 비즈니스 작업을 수행하는데 대기시간이 발생한다.
//
//    users.map(Dispatchers.Default) { user -> user.toSomething() /* `toSomething()` is heavy method */ }
//}


//만약 List A,B가 있다고 가정하자.
//B가 매핑하기 무겁기 때문에

