# 原型模式
*方便复制（大量）对象*
## 基础
1. 浅克隆
- 方式一
直接调用`super.clone()`,(该方法会抛出`CloneNotSupportedException`异常)

```java
public class Student implements Cloneable {
    public String id;//简化一点，全部声明为public方便赋值
    public String name;
    public String className;

    @Override
    public Object clone(){
        return super.clone();
    }
}
```
- 方式二
手动一个一个将成员变量赋值
```java
public class Student implements Cloneable{
    public String id;//简化一点，全部声明为public方便赋值
    public String name;
    public String className;
    
    @Override
    public Object clone(){
        Student student=new Student();
        student.id=id;
        student.name=name;
        student.className=className;
        return student;
    }
}
```
*但是一旦成员变量中有引用数据类型，拷贝过来是相同的引用，也就是说成员变量是共用一个*

2. 深克隆
- 方式一
成员变量（只要是引用数据类型）所属的类均实现Cloneable接口，重写clone方法（成员变量所属的类中的成员变量所属的类（引用数据类型）也需要实现Cloneable接口、重写clone方法，...以此类推，只要是引用数据类型，都需要实现Cloneable接口，重写clone方法），然后拷贝时只有是对引用数据类型赋值都是调用该对象的clone方法。
```java
public class Student implements Cloneable{
    public String id;
    public String name;
    public Class aClass;
    @Override
    public Object clone() throws CloneNotSupportedException{
        Student student= (Student) super.clone();
        student.aClass= (Class) this.aClass.clone();
        return student;
    }
//    或者这样也可以
//    @Override
//    public Object clone() throws CloneNotSupportedException{
//        Student student=new Student();
//        student.id=id;
//        student.name=name;
//        student.aClass=(Class) aClass.clone();
//        return student;
//    }
}
class Class implements Cloneable{
    public String id;
    public String name;
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
```
- 方式二
使用序列化与反序列化的方式，注意涉及到的类都需要实现Serializable接口
```java
public class Student implements Cloneable,Serializable{
    public String id;
    public String name;
    public Class aClass;

    @Override
    public Object clone() {
        ByteArrayOutputStream bos=null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try{
            bos=new ByteArrayOutputStream();
            oos=new ObjectOutputStream(bos);
            oos.writeObject(this);
            byte[] bytes=bos.toByteArray();
            bis=new ByteArrayInputStream(bytes);
            ois=new ObjectInputStream(bis);
            Student student=(Student) ois.readObject();
            return student;
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ois!=null) ois.close();
                if(bis!=null) bis.close();
                if(oos!=null) oos.close();
                if(ois!=null) ois.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}

class Class implements Serializable{
    public String name;
    public String id;
}
```

