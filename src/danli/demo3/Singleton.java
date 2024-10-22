package danli.demo3;

import java.io.Serializable;

//双重检查
public class Singleton implements Serializable {
    private static Singleton instance;
    private Singleton(){ }
    public static Singleton getInstance(){
        if (instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
    private Object readResolve(){
        return getInstance();
    }
}
