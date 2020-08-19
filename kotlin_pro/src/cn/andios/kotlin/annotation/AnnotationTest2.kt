package cn.andios.kotlin.annotation

import kotlin.reflect.KClass

// 注解也可以拥有自己的构造方法，并且构造方法也可以接受参数
// 注解构造方法所允许的参数类型：
//      与java原生类型所对应的类型(Int, Long ...)
//      字符串：String
//      classes (MyClass::class)
//      枚举：enums
//      其他的注解
//      上述类型的数组类型
// kotlin的注解参数是不允许为可空类型的，因为jvm不支持以null的形式存储注解属性值的
// 如果某个注解是被用作其他注解的参数，那么其名字就不需要以@开头

annotation class MyAnnotation2(val str: String) {

}

@MyAnnotation2("hello")
class MyClass4

annotation class MyAnnotation3(val str: String, val myAnnotation: MyAnnotation2)

@MyAnnotation3("test", MyAnnotation2("welcome"))
class MyClass5

// 如果需要将某个class作为注解的参数，那么请使用kotlin class（KClass)
// kotlin编译器会自动将其转换为Java Class
// 这样java代码就可以正常看到注解与参数了

annotation class MyAnnotation4(val arg1: KClass<*>, val arg2: KClass<out Any>)

@MyAnnotation4(String::class, Int::class)
class MyClass6 {
}


// 注解的使用处目标(use-site target)
// 在对类的属性或是主构造方法的参数声明注解时，会存在多个java元素都可以通过对应的kotlin元素生成出来
// 因此在所生成的java字节码中，就会存在多个可能的位置来生成相应的注解，若想精确指定如何生成注解，那么
// 可以使用注解的使用处目标方式来实现

class MyClass7(@field:MyAnnotation1 val arg1: String, // 注解field
               @get: MyAnnotation1 val arg2: String,  // 注解getter
               @param: MyAnnotation1 val arg3: String)  // 注解java构造参数