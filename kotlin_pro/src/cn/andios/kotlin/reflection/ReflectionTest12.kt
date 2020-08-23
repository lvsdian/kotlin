package cn.andios.kotlin.reflection

class MyTestClass1<K, V>{
    var k: K? = null
    var v: V? = null
}

fun main(args: Array<String>) {
    val myTestClassType = MyTestClass1::class

    println(myTestClassType.typeParameters)         // [K, V]
    println(myTestClassType.typeParameters.size)    // 2

    println("first type: ${myTestClassType.typeParameters[0]}")     // K
    println("first type: ${myTestClassType.typeParameters[1]}")     // V

}