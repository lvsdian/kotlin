package cn.andios.kotlin.coroutine1

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author lvsdian
 * Created on 2020-08-25
 */

// 全局协程类似于守护线程（daemon thread）
// 使用GlobalScope启动的活动协程并不会保持进程的生命，它们就像守护线程一样

fun main() {
    // 打印5次后，时间到了(2s)，协程退出
    GlobalScope.launch {
        repeat(100) {
            println("wc:$it")
            delay(400)
        }
    }
    Thread.sleep(2000)
}