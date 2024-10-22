package yuanxing.demo4;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student=new Student("114514", "张三",
                new Class("2222", "2021"));
        Student copy= (Student) student.clone();
        System.out.println(copy==student);
        System.out.println(copy);
        System.out.println(student);
        System.out.println(copy.getaClass()==student.getaClass());
    }
}