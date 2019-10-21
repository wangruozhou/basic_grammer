package demo.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理实现的工厂模式
 */
public class ProxyFactory {
    private Object obj;
    public ProxyFactory(Object obj) {
        this.obj = obj;
    }

    public Object getTransactionProxyInstance() {
        Object transaxtionProxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启事务");
                method.invoke(obj,args);
                System.out.println("关闭事务");
                return proxy;

            }
        });
        return transaxtionProxy;

    }

    public Object getLoggerProxyInstance() {
        Object loggerProxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启日志");
                method.invoke(obj,args);
                System.out.println("关闭日志");
                return proxy;
            }
        });
        return loggerProxy;
    }
}
