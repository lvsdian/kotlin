package cn.andios.kotlin.coroutine2

import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * @author lvsdian
 * Created on 2020-08-25
 */

// 当我们在协程的finally块中使用了挂起函数时，会导致出现CancellationException异常，原因在于运行着该
// 代码块的协程已经被取消了，通常情况下，这并不会产生什么问题，因为大多数关闭操作（比如说取消一个Job，关闭网络连接等）通常
// 都是非阻塞的，并不需要使用挂起函数，然而，在极少数情况下，当我们在一个取消的协程中进行挂起操作时，我们可以将相应的代码放置到
// withContext(NonCancellable){}当中，在这种结构中，我们实际上使用了withContext函数与NonCancellable上下文
fun main() = runBlocking {
    // 不执行delay后的打印
    val myJob1 = launch {
        try {
            repeat(10) {
                println("wc:$it")
                delay(500)
            }
        }finally {
            println("finally invoked")
            delay(1000)
            println("invoked after delay")
        }
    }
    delay(1300)
    println("hello")
    myJob1.cancelAndJoin()
    println("world")

    println("------------------")

    // 执行delay后的打印
    val myJob2 = launch {
        try {
            repeat(10) {
                println("wc:$it")
                delay(500)
            }
        }finally {
            withContext(NonCancellable) {
                println("finally invoked")
                delay(1000)
                println("invoked after delay")
            }
        }
    }
    delay(1300)
    println("hello")
    myJob2.cancelAndJoin()
    println("world")
}