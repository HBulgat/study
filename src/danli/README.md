# 单例模式
*一个类只有一个示例对象*
> 要点就是：
> 1. 私有化构造方法
> 2. 暴露getInstance方法
## 基础
1. 饿汉式
```java
public class Singleton{
    private static Singleton instance=new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }
}
```

2. 懒汉式
```java
//单线程安全，多线程有bug
public class Singleton{
    private static Singleton instance;
    private Singleton(){
    }
    public static Singleton getInstance(){
        if(instance==null){//多个线程先后进这里会造成多次实例化
            instance=new Singleton();
        }
        return instance;
    }
}
```
```java
//双重检查，多线程安全，但是性能低
public class Singleton{
    private static Singleton instance;
    private Singleton(){ }
    public static Singleton getInstance(){
        if(instance==null){//第一次判空
            synchronized (Singleton.class){
                if(instance==null){//第二次判断是不是空
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}
```
## 进阶
1. 枚举实现
```java
public enum Singleton{
    INSTANCE;
}
```
*序列化与反序列化不能破坏枚举实现的单例模式，但可以破坏别的方式实现的单例模式，
因为反序列化是调用readResolve方法，枚举类自动实现了该方法（不能重写），
所以对于前面的方式，只需要重写readResolve方法即可，如下：*

```java
import java.io.Serializable;

public class Singleton implements Serializable {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
    protected Object readResolve(){
        System.out.println("readResolve");
        return instance;
    }
}
```

或者：
```java
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
```

## volatile关键字
new一个对象有几个步骤。
1. 看class对象是否加载，如果没有就先加载class对象，
2. 分配内存空间，初始化实例，
3. 调用构造函数，
4. 返回地址给引用。  
- 而cpu为了优化程序，可能会进行指令重排序，打乱这3，4这几个步骤，导致实例内存还没分配，就被使用了。  
所以new一个对象的代码是无法保证顺序性的，因此，我们需要使用另一个关键字volatile(防止指令重排)保证对象实例化过程的顺序性。  
*饿汉式中需要*

```java
import java.io.Serializable;

public class Singleton implements Serializable {
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
    protected Object readResolve(){
        return instance;
    }
}
```




