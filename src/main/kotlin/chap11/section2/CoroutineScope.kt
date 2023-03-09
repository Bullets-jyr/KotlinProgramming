package chap11.section2

import kotlinx.coroutines.*

fun main() = runBlocking(Dispatchers.Default) {
    launch(Dispatchers.IO) {
        delay(200L)
        println("Task from runBlocking")
    }

    coroutineScope {
        launch {
            delay(200L)
            println("Task from nested launch")
        }
        delay(200L)
        println("Task from coroutineScope")
    }

    println("end of runBlocking")
}