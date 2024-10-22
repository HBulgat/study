package celue.demo1;

public class AddStrategy implements Strategy{
    @Override
    public int execute(int num1, int num2) {
        return num1+num2;
    }
}
