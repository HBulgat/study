package yuanxing.demo2;

public class Student implements Cloneable{
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
    public Object clone() throws CloneNotSupportedException {
        return super.clone();//浅拷贝
    }
}

class Class {
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

