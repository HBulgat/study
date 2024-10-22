package yuanxing.demo4;

import java.io.*;

//通过序列化,注意涉及到的类都需要实现Serializable接口，不然会报错
public class Student implements Cloneable,Serializable{
    private String id;
    private String name;
    private Class aClass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Student(String id, String name, Class aClass) {
        this.id = id;
        this.name = name;
        this.aClass = aClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", aClass=" + aClass +
                '}';
    }
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
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Class(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Class{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}


