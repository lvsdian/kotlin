package cn.andios.kotlin.coroutine4

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-28
 */

// 委托
class Activity: CoroutineScope by CoroutineScope(Dispatchers.Unconfined) {
    fun destroy() {
        cancel()
    }

    fun doSomething() {
        repeat(10) {
            launch {
                delay((it + 1) * 300L)
                println("coroutine $it is finished")
            }
        }
    }
}

//启动协程
//coroutine 0 is finished
//coroutine 1 is finished
//coroutine 2 is finished
//coroutine 3 is finished
//销毁
fun main() = runBlocking<Unit> {
    val activity = Activity()
    activity.doSomething()

    println("启动协程")
    delay(1300)

    println("销毁")
    activity.destroy()

    delay(10000)
}