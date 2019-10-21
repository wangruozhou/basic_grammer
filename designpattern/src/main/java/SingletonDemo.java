
public class SingletonDemo {
    public static void main(String[] args){
        SingletonThreadTest[] threadTests = new SingletonThreadTest[100];
        for(int i=0;i<threadTests.length;i++){
            threadTests[i] = new SingletonThreadTest();
        }
        for(int i=0;i<threadTests.length;i++){
            threadTests[i].start();
        }

    }



}

/**
 * 饿汉式
 * 在类加载的时候就生成对象，在程序运行完之后对象资源才会释放
 */
class Singleton1 {


    private Singleton1(){

    }
    private static Singleton1 singleton = new Singleton1();

    public static Singleton1 getInstance() {
        return singleton;
    }
}

/**
 * 懒汉式
 * 在创建实例的时候才会被加载
 */
class LazySingleton{
    private static LazySingleton lazySingleton;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}

class Singleton3{
    private Singleton3(){}
    private static class Holder {
        private static Singleton3 singleton = new Singleton3();
    }
    public static Singleton3 getInstance(){
        return Holder.singleton;
    }
}

class Singleton4 {
    private static volatile Singleton4 singleton;
    private Singleton4(){}
    public static Singleton4 getInstance(){
        //下面1所在的条件语句B线程是可以执行的，因为A线程已经执行完赋值操作，B线程会判定singleton中已经有值了，于是就把把singleton
        //返回给调用者了，但是这个时候，singleton是还未初始化完成的，这就有问题了啊，你给了别人一个未完成的对象。所以，要加
        //volatile关键字，保证不被虚拟机重排
        if(singleton == null){          //    1
            synchronized (Singleton4.class){
                if(singleton==null){    //      2
                    /**
                     * 下面的实例化操作包括
                     * 1. 申请资源
                     * 2. 初始化对象
                     * 3. 赋值操作
                     * 正常顺序是1-2-3 ，但jvm可能会重排变为1-3-2，在这种情况下，假如有
                     * A线程执行完1-3操作，然后这个时候有个线程在请求getInstance
                     */
                    singleton = new Singleton4();
                }
            }
        }
        return singleton;
    }
}


class SingletonThreadTest extends Thread {
    @Override
    public void run() {
        int hash = Singleton4.getInstance().hashCode();
        System.out.println(hash);
    }
}