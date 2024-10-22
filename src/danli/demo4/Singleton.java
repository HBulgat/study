package danli.demo4;

import java.io.Serializable;

public enum Singleton implements Serializable {//自动实现了readResolve方法
    INSTANCE;

    protected Object readResolve(){
        System.out.println("readSolve");
        return null;
    }
}
