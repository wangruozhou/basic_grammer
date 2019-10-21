package demo.reflection;

public class Demo1 {
    public static void main(String[] args){
        Test t = new Test();
        Class c = t.getClass();
        System.out.println(c.getName());
    }

}

class Test {
    public Test(){
        System.out.println("constract method Test run....");
    }
    public void test1(){

    }
}
