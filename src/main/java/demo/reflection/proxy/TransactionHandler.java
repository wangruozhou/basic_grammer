package demo.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionHandler implements InvocationHandler {
    private Object obj;
    public TransactionHandler(Object obj) {
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("TansactionHandler 事务开启");
        method.invoke(obj,args);
        System.out.println("TranscationHandler 事务关闭");
        return proxy;
    }

    public Object getInstance(){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }
}
