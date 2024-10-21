package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.util.Date

class SuspendFunctionTest {

    suspend fun helloWorld() {
        println("Hello : ${Date()} : ${Thread.currentThread().name}")
        delay(2_000)
        println("Hello : ${Date()} : ${Thread.currentThread().name}")
    }

    @Test
    fun testSuspendFunction() {
        runBlocking {
            helloWorld()
        }
    }
}