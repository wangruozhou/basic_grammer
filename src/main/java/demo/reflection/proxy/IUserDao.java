package demo.reflection.proxy;

import java.util.Date;

public interface IUserDao {
    void save();
    void delete(int id);
    void update(int id, String name, String pwd, Date date);
    int getData();

}
