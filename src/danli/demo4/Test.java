package danli.demo4;

import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Singleton instance1=Singleton.INSTANCE;
        File file=new File("data.txt");
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(instance1);
        oos.close();
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
        Object o = ois.readObject();
        ois.close();
        System.out.println(o==instance1);
//        System.out.println(((Singleton)o).getName());
    }
}
