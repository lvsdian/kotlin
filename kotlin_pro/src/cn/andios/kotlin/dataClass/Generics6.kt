package cn.andios.kotlin.dataClass

/**
 * @author lvsdian
 * Created on 2020-08-02
 */

class MyStorage<out T>(private var t: T) {
    fun getValue(): T {
        return this.t
    }

    // 泛型T设置为out(协变)后，只能作为返回值，不能作为参数，如果要作为参数，需要加上@UnsafeVariance注解
    fun setValue(t: @UnsafeVariance T) {
        this.t = t
    }
}

fun main(args: Array<String>) {
    var myStorage1: MyStorage<Int> = MyStorage(5)
    var myStorage2: MyStorage<Any> = myStorage1

    println(myStorage2.getValue()) // 5
    // 这里往myStorage2中放的是字符串，而myStorage1中的泛型类型是Int,但能成功打印
    // 因为java中的实现是类型擦除，即字节码层面是不区分上面的Int和Any，所以能存成功，实际取得时候，
    // 按照any类型来取，所以能打印成功
    myStorage2.setValue("hello")
    println(myStorage2.getValue()) // hello
}
