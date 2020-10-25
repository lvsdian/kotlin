package cn.andios.kotlin.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

/*
    onCompletion中间操作的一个优势在于它有一个可空的Throwable参数，可用作确定Flow
    的收集操作是正常完成还是异常完成
 */

private fun myMethod(): Flow<Int> = flow{
    emit(1)
    throw RuntimeException()
}

// onCompletion是在流收集完之后发生执行，无论异常有没有发生都会执行
fun main() = runBlocking{
    myMethod().onCompletion{cause ->
        if (cause != null)
            println("flow completed exceptionally")
    }.catch{cause ->
        println("catch entered")
    }.collect{
        println(it)
    }
}