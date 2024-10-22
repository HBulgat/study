package yuanxing.demo1;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student=new Student("114514", "张三", "2101班");
        Student clone= (Student) student.clone();
        System.out.println(student==clone);
        System.out.println(student);
        System.out.println(clone);
    }
}
