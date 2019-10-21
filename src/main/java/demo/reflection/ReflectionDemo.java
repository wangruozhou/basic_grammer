package demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * 编译方式说明：

 静态编译：在编译时确定类型 & 绑定对象。如常见的使用new关键字创建对象
 动态编译：运行时确定类型 & 绑定对象。动态编译体现了Java的灵活性、多态特性 & 降低类之间的藕合性

 * -----------
 * 反射
 * -Class类 核心类，可以获取类的属性方法
 * -Field类 Java.lang.reflect包中的类，可以获取和设置类的成员变量
 * -Method类 Java.lang.reflect包中的类，可以获取和执行类中的方法
 * -Contructor类 Java.lang.reflect包中的类，类中的构造方法
 * method,field,contructor每个都有4种方法获取，getXXX,getXXXXs,getDeclaredXXX,getDeclaredXXXs,
 * getXXX(name,)获取public,特定的值
 * getXXXs,获取public,所有的值
 * getDeclaredXXX(name,),获取public，非public，特定的值
 * getDexlaredXXXs,获取public，非public所有的值
 *
 * ----
 * 使用反射的步骤
 * 1. 获取想要的类的Class对象
 * 2. 调用Class类中的方法
 * 3. 使用反射来操作这些信息
 */
public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        useClass1();
        useClass2();

    }

    public static void useClass1() throws ClassNotFoundException {
        /*
        获取Class有三种方式
         */
        // 1.类名获取
        Class personClazz1 = Person.class;
        // 2.对象名获取
        Class personClazz2 = new Person().getClass();

        // 3.Class类的forName方法，这种方式最常见，所需要的依赖最少
        Class personClazz3 = Class.forName("demo.reflection.Person");

        // ------ 使用Class类
        /**
         * getConstructors可以获得所有public的构造方法
         * getDeclaredConstructors可以获得所有public和非public的构造方法
         * 获取method和field的方法也一样
         */
        //获取所有方法
        Method[] methods = personClazz3.getDeclaredMethods();
        System.out.println(">>>> 方法信息");
        for (Method method : methods) {
            System.out.println(method.toString());
        }
        //获取所有成员属性

        Field[] fields = personClazz3.getDeclaredFields();
        System.out.println(">>>> 成员属性");
        for (Field field : fields) {
            System.out.println(field.toString());
        }

        //获取所有构造方法
        Constructor[] constructors = personClazz3.getDeclaredConstructors();
        System.out.println(">>>> 构造方法");
        for (Constructor constructor : constructors) {
            System.out.println(constructor.toString());
        }
    }

    /**
     * 取得Class对象后，可以用来创建对应的实例,两种方式：
     * 1. 使用Class对象的newInstance()方法创建实例，这种方式需要类有空构造方法
     * 2. 使用Class获得对应的Contructor方法，然后再创建对应实例
     */
    public static void useClass2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1.
        Class personClazz = Class.forName("demo.reflection.Person");

        //（1）直接创建
        Person p1 =(Person) personClazz.newInstance();
        Method method1 = personClazz.getMethod("setAddress", String.class);
        // 相当于设置public,protect,private
        method1.setAccessible(true);
        //利用反射执行方法
        method1.invoke(p1,"p1_address");
//        p1.setAddress("p1_address");
        System.out.println("P1:\n"+p1);
        // （2）用指定的构造方法创建对象
        Constructor constructor = personClazz.getDeclaredConstructor(String.class, int.class);
        Person p2 = (Person) constructor.newInstance("张三", 20);

        System.out.println("P2:\n" + p2);
    }
}

class Person {
    String address = "default";
    String name = "default";
    int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAddress(String addr) {
        this.address = addr;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "name : " + name + "\n age : " + age + "\naddress : " + address;
    }
}
