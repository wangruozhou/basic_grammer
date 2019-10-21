package demo.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LoggerHandler implements InvocationHandler {
    private Object obj = null;

    public LoggerHandler(Object obj) {
        super();
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("LoggerHandler 开启日志");
        Object result = method.invoke(obj,args);
        System.out.println("LoggerHandler 关闭日志");
        return result;
    }

    public Object getInstance() {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }
}
