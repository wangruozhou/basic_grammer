package demo.reflection.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Object obj;

    public CglibProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CglibProxy run,,,日志开启");
        method.invoke(obj, args);
        System.out.println("CglibProxy run,,,日志关闭");
        return proxy;
    }

    public Object getInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
}
