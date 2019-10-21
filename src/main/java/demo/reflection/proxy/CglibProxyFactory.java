package demo.reflection.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory {
    private Object obj;

    public CglibProxyFactory(Object obj) {
        super();
        this.obj = obj;
    }

    public Object getTransactionProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());


        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("CglibProxy 事务开启");
                method.invoke(obj,args);
                System.out.println("CglibProxy 事务关闭");
                return proxy;
            }
        });
        return enhancer.create();
    }
}
