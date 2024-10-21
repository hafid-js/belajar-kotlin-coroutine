package org.example

import com.sun.source.tree.Scope
import kotlinx.coroutines.*


fun main() {
    val exceptionhandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("La exception $throwable ha sido cachada...")
    }

    val coroutineScope = CoroutineScope(SupervisorJob() + exceptionhandler)

    coroutineScope.launch {
        print("Coroutine #1 inciada...")
        delay(100)
        println("Corroutina #1 fallida")
        lanzarException()
    }
    coroutineScope.launch {
        print("Coroutine #2 inciada...")
        delay(500)
        println("Corroutina #2 fallizada")
        lanzarException()
    }.invokeOnCompletion {
        if (it is CancellationException) {
            println("Corroutina #2 cancelada...")
        }
    }

    Thread.sleep(1000)

    println("Coroutina padre continua activaL ${coroutineScope.isActive}")
}

private fun lanzarException() {
    throw NullPointerException()
}