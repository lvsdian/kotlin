package cn.andios.kotlin.objectDeclaration

/**
 * @author lvsdian
 * Created on 2020-07-31
 */

/**
 * object declaration:对象声明
 *  如下，表示声明了一个对象，这个对象名字叫MyClass，这个对象可以拥有属性，也可以拥有方法
 */
object ObjectDemo {
    fun method() {
        println("method")
    }
}

fun main(args: Array<String>) {
    // 对象声明
    ObjectDemo.method()
}


// different：对象表达式/对象声明
//  1.对象表达式是立刻初始化或是执行的
//  2.对象声明是延迟初始化的，在首次访问的时候进行
//  3.伴生对象是在其锁对应的类在加载时初始化的，对应于java的静态初始化