package cn.andios.kotlin.coroutine2

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * @author lvsdian
 * Created on 2020-08-26
 */

// 由withTimout函数调用所抛出的的TimeoutCancellationException异常是CancellationException的子类，当该异常抛出
// 时，我们并未在控制台看到整个异常的堆栈信息，这是因为在取消的协程当中，CancellationException被认为是一种协程完成
// 的正常原因而已
// 不过我们在该示例中，是在main函数中使用了withTimeout函数使用
// 既然CancellationException仅仅是个异常而已，所有的资源也都会以通常的方式来关闭，那么我们就可以将相关代码放到一个try...catch
// 块中，此外，kotlin还提供了另外一个更加友好的函数调用：withTimeoutOrNull；从功能角度看，它非常类似于withTimeout,不过当超时发生时，
// 它并不会抛出CancellationException异常，而是会直接返回null
// 对于withTimeout函数调用来说，如果将其放置到try...catch中，那么调用形式是下面这样的
//  try {
//      ...
//  } catch (ex: TimeoutCancellationException) {
//      ...
// }

fun main() = runBlocking {
    // repeat没有执行完，result就是null，执行完了，result就是hello
    val result = withTimeoutOrNull(2000) {
        repeat(10) {
            println("wc:$it")
            delay(500)
        }
        "hello"
    }
    println("result is $result")
}