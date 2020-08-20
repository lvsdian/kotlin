package cn.andios.kotlin.kotlin2java;

import java.io.IOException;

/**
 * @description:
 * @author:LSD
 * @when:2020/08/21/0:12
 */
public class MyException {
    public void myMethod() throws IOException {
        throw new IOException("IO 异常");
    }
}
