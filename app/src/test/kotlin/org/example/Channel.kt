package org.example

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking(CoroutineName("main")) {
    val channel = Channel<Int>()
        launch(CoroutineName("v1Coroutine")) {
            println("Sending from ${Thread.currentThread().name}")
            for (x in 1..5) channel.send(x * x)
        }

    repeat(5) {
        println(channel.receive())
    }
    println("receive value in ${Thread.currentThread().name}")
}