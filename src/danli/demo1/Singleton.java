package danli.demo1;
//懒汉式
public class Singleton {
    private static Singleton instance=new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }
}
