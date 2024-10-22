package yuanxing.demo1;

//实现Cloneable接口
public class Student implements Cloneable{
    private String id;
    private String name;
    private String className;
    public Student(){
    }
    public Student(String id,String name,String className){
        this.id=id;
        this.name=name;
        this.className=className;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
//        Student student=new Student();
//        student.id=id;
//        student.name=name;
//        student.className=className;
//        return student;
        Student student= (Student) super.clone();
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
