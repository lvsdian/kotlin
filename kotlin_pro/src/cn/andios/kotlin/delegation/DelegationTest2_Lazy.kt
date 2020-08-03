package cn.andios.kotlin.delegation

/**
 * @author lvsdian
 * Created on 2020-08-03
 */

// 延迟属性：指的是属性只在第一次被访问的时候才会计算，之后会将之前的计算结果缓存起来供后续调用


// lazy是一个函数，会接收一个lambda表达式，这个lambda表达式会返回一个Lazy<T>类型，它可以作为一个委托，实现延迟属性
// lazy参数：LazyThreadSafetyMode，
//      1.SYNCHRONIZED：默认情况，延迟属性的计算是同步的，保证只有一个线程会初始化lazy实例
//      2.PUBLICATION：如果不需要初始化委托的同步，这样多个线程可以同时执行，但只有第一个线程返回的值会用作lazy实例
//      3.NONE：不会加锁来对访问lazy实例的线程进行同步，如果确定初始化操作只会在一个线程中执行，这样会将减少线程安全方面的开销，但多线程环境下有安全问题
val myLazyValue: Int by lazy (LazyThreadSafetyMode.NONE) {
    println("hello")

    30
}

fun main(args: Array<String>) {
    // 第一次打印，会执行lazy块，所以会打印 hello 30
    println(myLazyValue)
    // 第二次打印，因为已经计算过了，所以lazy块中的30就是myLazyValue的值，所以只会打印 30
    println(myLazyValue)
}
