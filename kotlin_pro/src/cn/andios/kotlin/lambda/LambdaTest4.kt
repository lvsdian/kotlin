package cn.andios.kotlin.lambda

/**
 * @author lvsdian
 * Created on 2020-08-05
 */
fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuffer()

    for(index in 0 until length) {
        val ele = get(index)
        if(predicate(ele)) {
            sb.append(ele)
        }
    }
    return sb.toString()
}

fun main(args: Array<String>) {
    var str = "12a3bc23fae3"
    println(str.filter { it.isDigit() })
    println(str.filter { it.isLetter() })
}
