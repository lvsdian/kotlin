package cn.andios.kotlin.coroutine4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asContextElement
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

/**
 * @author lvsdian
 * Created on 2020-08-28
 */

// ThreadLocal

val threadLocal = ThreadLocal<String>()

// pre main current thread:main @coroutine#1, threadLocal value:hello
// launch start,current thread:DefaultDispatcher-worker-1 @coroutine#2, threadLocal value:world
// launch start,current thread:DefaultDispatcher-worker-2 @coroutine#2, threadLocal value:world
// post main,current thread:main @coroutine#1, threadLocal value:hello
// 分析：原来的线程是main，threadLocal保存的值是hello
//  后来切换了线程，threadLocal保存的值变为world
// 再次切换到main线程，threadLocal值又恢复到原来的值hello
fun main() = runBlocking {
    threadLocal.set("hello")
    println("pre main current thread:${Thread.currentThread().name}, threadLocal value:${threadLocal.get()}")

    val job = launch(Dispatchers.Default + threadLocal.asContextElement(value = "world")) {
        println("launch start,current thread:${Thread.currentThread().name}, threadLocal value:${threadLocal.get()}")
        yield()
        println("launch start,current thread:${Thread.currentThread().name}, threadLocal value:${threadLocal.get()}")
    }
    job.join()
    println("post main,current thread:${Thread.currentThread().name}, threadLocal value:${threadLocal.get()}")
}


