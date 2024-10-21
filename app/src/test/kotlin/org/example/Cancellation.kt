package org.example

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program starts : ${Thread.currentThread().name}")

    val job: Job = launch(Dispatchers.Default) {
        for (i in 0..500) {
            if (!isActive) {
//                break
                return@launch
            }
            print("$i.")
            Thread.sleep(1)
        }
}

     delay(10)
    job.cancelAndJoin()
    println("\nMain program ends : ${Thread.currentThread().name}")


}