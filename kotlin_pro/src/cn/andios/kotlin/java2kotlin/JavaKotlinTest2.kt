package cn.andios.kotlin.java2kotlin

// 如果在kotlin文件中写了包级别的（不属于任何一个具体的类）属性或方法，那么这个方法或属性将成为
// 它所在的"文件名+Kt"类的静态成员变量和静态方法，调用时根据类名调用即可（方法直接调用，属性通过get/set调用）

// 反编译：public final class cn.andios.kotlin.java2kotlin.MyClass
class MyClass

// 反编译：public startic final void test();
fun test() {
    println("hello")
}

// 反编译：private static final java.lang.String str;
var str: String = "world"

