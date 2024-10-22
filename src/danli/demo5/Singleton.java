package danli.demo5;


import java.io.Serializable;

//序列化与反序列化会使得demo1中的单例被破坏
public class Singleton implements Serializable {
    private static Singleton instance=new Singleton("instance");
    private String name;
    public String getName(){
        return name;
    }
    private Singleton(String name){
        this.name=name;
    }
    public static Singleton getInstance(){
        return instance;
    }
    protected Object readResolve(){
//        System.out.println("readSolve");
        return instance;
    }
}
