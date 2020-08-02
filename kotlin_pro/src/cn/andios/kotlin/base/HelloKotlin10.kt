package cn.andios.kotlin.base

/**
 * @author lvsdian
 * Created on 2020-07-30
 */
fun main(args: Array<String>) {
    var a: String = "hello \\n world"
    println("a:$a")

    var b: String = """
        \n hello
        world \n
    """.trimIndent()
    println("b:$b")

    var c: String = """
        \n hello
        world \n
    """
    println("c:$c")
}