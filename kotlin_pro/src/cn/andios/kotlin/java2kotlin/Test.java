package cn.andios.kotlin.java2kotlin;

import static java.lang.System.out;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import cn.andios.kotlin.exception.Test11;

/**
 * @description:
 * @author:LSD
 * @when:2020/08/21/0:39
 */
public class Test {
    public static void main(String[] args) {
        out.println("Test2：");
        // 我们无法通过new关键字来创建kotlin编译器自动生成的以Kt结尾的类的实例
        // 因为生成的字节码中没有不带参数的构造方法
        //JavaKotlinTest2Kt j = new JavaKotlinTest2Kt();

        MyClass myClass = new MyClass();

        JavaKotlinTest2Kt.setStr("111");
        out.println(JavaKotlinTest2Kt.getStr());

        JavaKotlinTest2Kt.test();


        out.println("-------------------");
        out.println("Test3、4：");

        // JavaKotlinTest3.kt和JavaKotlinTest4.kt都使用了  @file:JvmName("JavaKotlinTest") 本来应该会产生冲突，
        // 再加一个 @file:JvmMultifileClass 后，会把两个文件中的方法、变量都放到JavaKotlinTest类中，所以这里可以直接调用
        JavaKotlinTest.myPrint1();
        JavaKotlinTest.myPrint2();

        out.println("----------------");
        out.println("Test5：");

        // 只能获取name，不能获取age
        out.println(JavaKotlinTest5.getName());

        out.println("----------------");
        out.println("Test6：");


        // 获取半生对象属性,但如果有@JvmField就不一样了
        out.println(Test6.Companion.getName());
        out.println(Test6.age);

        out.println("-----------------");
        out.println("Test7：");


        // 不加@JvmStatic相当于访问Test7静态内部类Companion的方法
        Test7.Companion.test1();
        Test7.Companion.test2();
        // 加了@JvmStatic后，test2()既是Companion的静态方法，又是Test7的静态方法
        Test7.test2();

        out.println("------------------");
        out.println("Test8：");


        out.println(Test8.myFilter(new ArrayList<>()));
        out.println(Test8.myFilter2(new ArrayList<>()));

        out.println("----------------------");
        out.println("Test9：");


        Test9 test9 = new Test9();
        out.println(test9.getA());
        out.println(test9.getAValue());

        out.println("--------------------");
        out.println("Test10：");

        // Kotlin中的构造器用@JvmOverloads修饰后，java调用时有两种调法，
        // 一种是全参数
        // 一种是当前参数 + 不含默认值的参数
        // 另一种是不含默认值的参数
        //Test10 test10 = new Test10();

        out.println("--------------------");
        out.println("Test11：");

        // kotlin中的method()方法抛出了异常，如果这里不捕获，会抛异常，后续代码无法执行
        // 如果这里捕获，又无法捕获，因为kotlin不存在checked exception，直接捕获会报错
        // 解决办法：kotlin中加上@Throws注解
        Test11 test11 = new Test11();
        try {
            test11.method();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.println("111");

        out.println("---------------------");
        out.println("Test12：");

        Test12 test12 = new Test12();
        // kotlin中要求为String，这里传null，编译不会报错，但运行会报IllegalArgumentException异常
        // 除非将kotlin中改为String?
        test12.method(null);

    }
}
