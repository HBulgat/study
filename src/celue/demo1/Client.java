package celue.demo1;

public class Client {
    public static void main(String[] args) {
        Context context=new Context(new AddStrategy());
        System.out.println(context.executeStrategy(100,10));
    }
}
