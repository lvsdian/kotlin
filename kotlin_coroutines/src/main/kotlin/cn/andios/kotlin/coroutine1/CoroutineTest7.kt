package cn.andios.kotlin.coroutine1

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-25
 */

// 除去不同的协程构建器所提供的协程作用域（coroutine scope）外，我们还可以通过coroutineScope builder来声明自己的协程作用域
// 该构建器会创建一个协程作用域，并且会等待所有启动的子协程全部完成后自身才会完成
// runBlocking与coroutineScope之间的主要差别在于，后者在等待所有子协程完成其任务时并不会阻塞当前线程
//      runBlocking并非挂起函数；也就是说，调用它的线程会一直位于该函数中，一直到协程执行完为止
//      coroutineScope是挂起函数，也就是说，如果其中的协程挂起，那么coroutineScope函数也会挂起，这样，创建
//          coroutineScope的外层函数就可以继续在同一个线程中执行了，该线程会【逃离】coroutineScope之外，并且可以做其他事情

//      如下，coroutineScope是挂起函数，所以线程执行到coroutineScope后，由于launch中在delay，所以线程返回（此时coroutineScope没有执行完，coroutineScope并没有阻塞线程）到runBlocking中，去循环
//      runBlocking中的在coroutineScope之前的eventLoop，所以会打印my job1，等到coroutineScope执行完（delay完）后，再打印下面的welcome

fun main() = runBlocking {
    // hello --> my job1 --> world --> my job2 --> welcome
    // launch不会阻塞当前线程
    launch {
        delay(1000)
        println("my job1")
    }
    println("hello")
    // coroutineScope会等待它所有的子协程全部完成后才退出
    coroutineScope {
        launch {
            delay(4000)
            println("my job2")
        }
        delay(2000)
        println("world")
    }
    println("welcome")
}
