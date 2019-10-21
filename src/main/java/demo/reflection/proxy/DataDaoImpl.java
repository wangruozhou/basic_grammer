package demo.reflection.proxy;

public class DataDaoImpl implements IDataDao {

    @Override
    public void store() {
        System.out.println("DataDaoImpl store running ...");
    }
}
