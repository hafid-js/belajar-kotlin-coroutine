package org.example

import kotlinx.coroutines.*
import kotlin.math.log
import kotlin.system.measureTimeMillis

private fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")
fun main() = runBlocking {
    val networkRequest = async(start = CoroutineStart.LAZY) { networkRequest() }

    log(networkRequest.await())
}

//private suspend fun doBothOperations() = coroutineScope {
//    val time = measureTimeMillis {
//
//        val sum = async { addNumbers(10, 12) }
//        val product = async { multiplyNumbers(20, 2) }
//
//
//        log("The sum of add numbers is : ${sum.await()} and the product of multiplyNumbers is : ${product.await()}")
//
//    }
//
//    log("Completed in $time ms")
//}
//
//private suspend fun addNumbers(n: Int, n2:Int): Int {
//    delay(2000)
//    return n + n2
//}
//
//private suspend fun multiplyNumbers(n: Int, n2: Int): Int {
//    delay(2500)
//    return n * n2
//}

private suspend fun networkRequest(): String {
    repeat(3) {
        delay(1000)
        println("Making network request")
    }

    delay(2000)
    return "Network request successful!"
}