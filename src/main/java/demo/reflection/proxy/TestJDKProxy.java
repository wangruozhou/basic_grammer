package demo.reflection.proxy;

import org.junit.Test;

import java.util.Date;

public class TestJDKProxy {
    /**
     * 测试 jdk动态代理 工厂模式
     */
    @Test
    public void test1() {
        IUserDao userDao = new UserDaoMysqlImpl();
        IUserDao userDaoProxy = (IUserDao) new ProxyFactory(userDao).getTransactionProxyInstance();
        userDaoProxy.save();
        userDaoProxy.delete(11);
        userDaoProxy.update(12, "张三", "12345", new Date());
    }

    /**
     * 测试 jdk动态代理，非工厂模式
     */
    @Test
    public void test2() {
        IUserDao userDao = new UserDaoOracleImpl();
        IUserDao userDaoProxy = (IUserDao) new LoggerHandler(userDao).getInstance();
        userDaoProxy.save();
        userDaoProxy.delete(11);
        userDaoProxy.update(12, "张三", "12345", new Date());
        int result  = (int)userDaoProxy.getData();
        System.out.println("proxy :" +result);

    }

    /**
     * 测试Cglibroxy
     */
    @Test
    public void test3() {
        UserDaoImpl userDao = new UserDaoImpl();
        UserDaoImpl userDaoProxy = (UserDaoImpl) new CglibProxy(userDao).getInstance();
        userDaoProxy.save();
        System.out.println("目标对象类型："+userDao.getClass());
        System.out.println("代理对象类型："+ userDaoProxy.getClass());
    }

    /**
     * 测试Cglib 工厂模式
     */
    @Test
    public void test4() {
        UserDaoImpl userDao = new UserDaoImpl();
        UserDaoImpl userDaoProxy = (UserDaoImpl) new CglibProxyFactory(userDao).getTransactionProxy();
        userDaoProxy.save();
        System.out.println("目标对象类型："+userDao.getClass());
        System.out.println("代理对象类型："+ userDaoProxy.getClass());
    }

    @Test
    public void test5(){
        DataDaoImpl dataDao = new DataDaoImpl();
        IDataDao dataDaoProxy = (IDataDao) new TransactionHandler(dataDao).getInstance();
        dataDaoProxy.store();
    }


}
