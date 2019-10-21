package demo.reflection;

import java.lang.reflect.Constructor;

public class UseReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("demo.reflection.Test");
        System.out.println("获取共有构造方法");
        Constructor[] constructors = c.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

}
