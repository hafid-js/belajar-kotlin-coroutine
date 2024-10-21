package org.example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        println("C1: ${Thread.currentThread().name}")
        delay(1000)
        println("C1 after delay: ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Default ) {
        println("C2: ${Thread.currentThread().name}")
        delay(1000)
        println("C2 after delay : ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Unconfined) {
        println("C3: ${Thread.currentThread().name}")
        delay(100)
        println("C3 after delay: ${Thread.currentThread().name}")
    }

    // Using Coroutine Context
    launch(coroutineContext) {
        println("C4: ${Thread.currentThread().name}")
        delay(1000)
        println("C4 after delay: ${Thread.currentThread().name}")
    }

    println("....Main Program....")
}