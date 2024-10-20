package org.example

import org.junit.jupiter.api.Test
import java.util.Date
import java.util.concurrent.Executors

class ExecutorServiceTest {

    @Test
    fun testSingleThreadPool() {
        val executorService = Executors.newSingleThreadExecutor()
        repeat(10) {
            val runnable = Runnable {
                Thread.sleep(1000)
                println("Done $it ${Thread.currentThread().name} ${Date()}")
            }
            executorService.execute(runnable)
        }

        println("Menunggu")
        Thread.sleep(11_000)
        println("Selesai")
    }

    @Test
    fun testFixedThreadPool() {
        val executorService = Executors.newFixedThreadPool(3)
        repeat(10) {
            val runnable = Runnable {
                Thread.sleep(1000)
                println("Done $it ${Thread.currentThread().name} ${Date()}")
            }
            executorService.execute(runnable)
        }

        println("Menunggu")
        Thread.sleep(11_000)
        println("Selesai")
    }

    @Test
    fun testCacheThreadPool() {
        val executorService = Executors.newCachedThreadPool()
        repeat(10) {
            val runnable = Runnable {
                Thread.sleep(1000)
                println("Done $it ${Thread.currentThread().name} ${Date()}")
            }
            executorService.execute(runnable)
        }

        println("Menunggu")
        Thread.sleep(11_000)
        println("Selesai")
    }
}