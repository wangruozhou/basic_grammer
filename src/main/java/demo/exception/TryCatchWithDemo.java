package demo.exception;

import java.io.*;

public class TryCatchWithDemo {

    public static void main(String[] args) {


    }

    /**
     * 正常try-catch方法捕获异常，finally需要多写一层catch，并且BufferedReader需要提前声明
     *
     * @param filePath
     */
    public static void readFileWithTryCatch(String filePath) {
        BufferedReader reader = null;
        String buffer = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            do {
                buffer = reader.readLine();
                System.out.println(buffer);
            } while (reader.read() != -1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * try()里的资源会自动关闭
     * @param filePath
     */
    public static void readFileWithTryWithResource(String filePath) {
        String buffer = null;
        try(BufferedReader reader = new BufferedReader((new FileReader(filePath)))){
            do {
                buffer = reader.readLine();
                System.out.println(buffer);
            }while (reader.read()!=-1);
        }catch (IOException e){
            e.printStackTrace();
        }






    }


}
