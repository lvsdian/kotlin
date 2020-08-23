package cn.andios.kotlin.reflection

// 构造方法引用（constructor reference）
// 要求有两点：
//      1.函数对象的参数要与构造方法的参数保持一致（体现在参数个数与参数类型上）
//      2.函数对象的返回结果要与构造方法所在类的类型保持一致

class Test9(val x: Int)

// factory函数的参数与构造方法相同，返回值也相同
fun myMethod(factory: (x: Int) -> Test9) {
    val test: Test9 = factory(1)
    println(test.x)
}

fun main(args: Array<String>) {
    // 构造方法引用
    myMethod(::Test9)
}