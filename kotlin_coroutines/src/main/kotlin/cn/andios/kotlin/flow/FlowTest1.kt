package cn.andios.kotlin.flow

/**
 * @author lvsdian
 * Created on 2020-08-28
 */

// 直接返回一个集合的做法有两个特点
// 1.方法本身是阻塞的，即主线程会进入到该方法中执行，一直执行到该方法返回为止
// 2.集合本身是一次性返回给调用端的，即集合中的元素均已经全部获取到后才一同返回给调用端

// 阻塞主线程，计算结果一次性返回
private fun myMethod(): List<String> = listOf("111", "222", "333")

fun main() {
    myMethod().forEach { println(it) }
}