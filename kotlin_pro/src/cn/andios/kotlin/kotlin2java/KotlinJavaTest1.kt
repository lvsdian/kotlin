package cn.andios.kotlin.kotlin2java

/**
 * @author lvsdian
 * Created on 2020-08-19
 */

fun main(args: Array<String>) {
    val list1 = ArrayList<String>()

    list1.add("hello")
    list1.add("world")

    for (i in 0 until list1.size) {
        println(list1[i])
    }

    println("----------------------------")

    var person = Person()
    person.age = 20
    person.isMarried = false
    person.name = "张三"

    println(person.age)
    println(person.isMarried)
    println(person.name)

    println("-----------------------------")

    // 在java中，所有引用都可能为null，而在kotlin中，对null是有着严格的检查与限制的，这就使得某个来自于java的引用在kotlin中
    // 变得不再合适，基于这个原因，在kotlin中，将来自于java的声明类型称为平台类型(platform types)
    // 对于这种类型（平台类型）来说，kotlin的null检查就会得到一定的缓和，变得不再那么严格了，这样就使得空安全的语义要求变得与java一致
    // 当我们调用平台类型引用的方法时，kotlin就不会在编译期间施加空安全检查，使得编译可以安全通过，但在运行期间有可能抛出异常，因为平台类型引用值
    // 可能为null

    val list2 = ArrayList<String>()
    //list2.add("hello")
    val size = list2.size
    val item = list2[0] // java.lang.IndexOutOfBoundsException: Index: 0, Size: 0

    val s1: String? = item // 允许，总是可以的
    val s2: String = item // 允许，不过在运行期可能失败

    // 如果我们使用了不可空类型，编译器会在赋值时生成一个断言，这会防止kotlin的不可空变量持有null值；
    // 同样，这一点也适用于kotlin方法传递，我们在将一个平台类型值传递给方法的一个不可空参数时，也会生成一个断言
    // 总体来说，kotlin会竭尽所能防止null的赋值蔓延到程序的其他地方，在发生问题之处就立刻通过断言来解决
}
