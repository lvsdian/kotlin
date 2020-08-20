package cn.andios.kotlin.kotlin2java

// kotlin中数组是不变的(相对于协变/逆变来说)，这一点与java明显不同
// 这意味着，我们无法将一个Array<String>赋给Array<Any>
// （在java中可以 Object[] objects = new String[2]; 这么做的问题就是  objects[0] = 1;  在编译器不会报错，但运行期报错）
// kotlin提供了原生类型数组来避免自动装箱与拆箱带来的成本：IntArray、DoubleArray

fun main(args: Array<String>) {

    val myArray = MyArray()

    val intArray: IntArray = intArrayOf(1, 2, 3, 4)
    val a: Array<Int> = arrayOf(1, 2)

    myArray.myMethod(intArray)
    // required：IntArray! ，not Array<Int>
    //myArray.myMethod(a)

    println("-------------------------------")

    //当编译为JVM字节码时，编译器会优化对于数组的访问，使之不会产生额外的成本
    val array = arrayOf(1, 2)
    array[0] = array[0] * 2 //并不会调用set或get方法

}