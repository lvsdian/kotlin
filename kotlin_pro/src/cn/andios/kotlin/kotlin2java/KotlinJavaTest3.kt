package cn.andios.kotlin.kotlin2java



fun main(args: Array<String>) {
    val myVarargs = MyVarargs()
    val strArrays = arrayOf("hello", "world")

    // String...  -->  String!
    // * 相当于把 strArrays 打散，spread operator
    myVarargs.myMethod(*strArrays)
}