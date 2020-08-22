package cn.andios.kotlin.java2kotlin;

import static java.lang.System.out;

import java.util.ArrayList;

/**
 * @description:
 * @author:LSD
 * @when:2020/08/21/0:39
 */
public class Test {
    public static void main(String[] args) {
        // 我们无法通过new关键字来创建kotlin编译器自动生成的以Kt结尾的类的实例
        // 因为生成的字节码中没有不带参数的构造方法
        //JavaKotlinTest2Kt j = new JavaKotlinTest2Kt();

        MyClass myClass = new MyClass();

        JavaKotlinTest2Kt.setStr("111");
        out.println(JavaKotlinTest2Kt.getStr());

        JavaKotlinTest2Kt.test();


        out.println("-------------------");

        // JavaKotlinTest3.kt和JavaKotlinTest4.kt都使用了  @file:JvmName("JavaKotlinTest") 本来应该会产生冲突，
        // 再加一个 @file:JvmMultifileClass 后，会把两个文件中的方法、变量都放到JavaKotlinTest类中，所以这里可以直接调用
        JavaKotlinTest.myPrint1();
        JavaKotlinTest.myPrint2();

        out.println("----------------");

        // 只能获取name，不能获取age
        out.println(JavaKotlinTest5.getName());

        out.println("----------------");

        // 获取半生对象属性,但如果有@JvmField就不一样了
        out.println(Test6.Companion.getName());
        out.println(Test6.age);

        out.println("-----------------");

        // 不加@JvmStatic相当于访问Test7静态内部类Companion的方法
        Test7.Companion.test1();
        Test7.Companion.test2();
        // 加了@JvmStatic后，test2()既是Companion的静态方法，又是Test7的静态方法
        Test7.test2();

        out.println("------------------");

        out.print(Test8.myFilter(new ArrayList<>()));
        out.print(Test8.myFilter2(new ArrayList<>()));

        out.println("--------------------");

        Test9 test9 = new Test9();
        out.println(test9.getA());
        out.println(test9.getAValue());

        out.println("--------------------");

        // Kotlin中的构造器用@JvmOverloads修饰后，java调用时有两种调法，
        // 一种是全参数
        // 一种是当前参数 + 不含默认值的参数
        // 另一种是不含默认值的参数
        //Test10 test10 = new Test10();
    }
}
