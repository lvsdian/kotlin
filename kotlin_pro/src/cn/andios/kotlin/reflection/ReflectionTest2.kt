package cn.andios.kotlin.reflection

/**
 * @author lvsdian
 * Created on 2020-08-23
 */

fun main(args: Array<String>) {
    val son: Parent = Son()
    val daughter: Parent = Parent()

    println(son::class)     // class cn.andios.kotlin.reflection.Son
    println(son::class.java)        // class cn.andios.kotlin.reflection.Son

    println("---------------")

    println(daughter::class)        // class cn.andios.kotlin.reflection.Parent
    println(daughter::class.java)       // class cn.andios.kotlin.reflection.Parent
}

open class Parent

class Son: Parent()

class Daughter: Parent()
