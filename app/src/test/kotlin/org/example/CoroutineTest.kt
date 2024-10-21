package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
<<<<<<< HEAD
import java.util.Date
import kotlin.concurrent.thread
=======
>>>>>>> origin/master

class CoroutineTest {

    suspend fun hello() {
        delay(1_000)
        println("Hello World")
    }

    @Test
    fun testCoroutine() {
        GlobalScope.launch {
            hello()
        }
        println("MENUNGGU")
        runBlocking {
            delay(2_000)
        }
        println("SELESAI")
    }
<<<<<<< HEAD

    @Test
    fun testThread() {
        repeat(10_000) {
            thread {
                Thread.sleep(1_000)
                println("Done $it : ${Date()}")
            }
        }

        println("Waiting")
        Thread.sleep(3_000)
        println("Finish")
    }

    @Test
    fun testCoroutineMany() {
        repeat(10_000) {
            GlobalScope.launch {
                delay(1_000)
                println("Done $it : ${Date()} : ${Thread.currentThread().name}")
            }
        }

        println("Waiting")
        runBlocking {
            delay(3_000)
        }
        println("Finish")
    }

=======
>>>>>>> origin/master
}