package cn.andios.kotlin.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

/*
    flow的完成

    kotlin提供了两种方式来实现flow的完成
    1. 命令式
    2. 声明式
 */

private fun myMethod(): Flow<Int> = (1..10).asFlow()


fun main() = runBlocking<Unit> {
    try{
        myMethod().collect{ println(it)}
    } finally {
        println("finally")
    }
}