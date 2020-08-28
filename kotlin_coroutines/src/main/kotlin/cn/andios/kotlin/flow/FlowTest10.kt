package cn.andios.kotlin.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

/**
 * @author lvsdian
 * Created on 2020-08-28
 */

// 限定大小的中间操作

fun myNumbers(): Flow<Int> = flow {

    try {
        emit(1)
        emit(2)
        emit(3)
    } finally {
        println("finally")
    }
}

fun main() = runBlocking {
    myNumbers().take(2)
        .collect { println(it) }
}