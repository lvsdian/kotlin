package cn.andios.kotlin.java2kotlin;

/**
 * @description:
 * @author:LSD
 * @when:2020/08/21/0:39
 */
public class JavaKotlinTest2 {
    // 我们无法通过new关键字来创建kotlin编译器自动生成的以Kt结尾的类的实例
    // 因为生成的字节码中没有不带参数的构造方法
//    JavaKotlinTest2Kt j = new JavaKotlinTest2Kt();

    MyClass myClass = new MyClass();

//    JavaKotlinTest2Kt.setStr("111")
//    System.out.println(JavaKotlinTest2Kt.test());
//
//    JavaKotlinTest2Kt.test();

}
