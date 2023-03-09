package chap11.section2

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job = GlobalScope.launch {
            delay(1000L)
            println("World")
            doSomething()
        }
        println("Hello")
        println("job: $job")
        println("job: ${job.isActive}, ${job.isCompleted}")
    //    Thread.sleep(2000L)
        job.join()
        println("job: $job")
        println("job: ${job.isActive}, ${job.isCompleted}")
    }
}

suspend fun doSomething() {
    println("Do Something")
}