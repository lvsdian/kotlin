package cn.andios.kotlin.exception

import java.io.FileNotFoundException

/**
 * @author lvsdian
 * Created on 2020-08-23
 */

// kotlin中不存在checked exception
class Test11 {

    // 这里加了@Throws注解，java代码中才能用try-catch捕获
    @Throws(FileNotFoundException::class)
    fun method() {
        println("method invoked")
        // 抛出异常
        throw FileNotFoundException()
    }
}
