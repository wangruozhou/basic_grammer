package demo.reflection.proxy;

import java.util.Date;

public class UserDaoMysqlImpl implements IUserDao {
    @Override
    public void save() {
        System.out.println("mysql save run ...");
    }

    @Override
    public void delete(int id) {
        System.out.println("mysql delete id :" + id);
    }

    @Override
    public void update(int id, String name, String pwd, Date date) {
        System.out.println(String.format("mysql update id:%d name:%s,pwd:%s,date:%s", id,name,pwd,date));
    }

    @Override
    public int getData() {
        return 0;
    }
}
