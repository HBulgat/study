package celue.demo2;

public class SubtractStrategy implements Strategy {
    @Override
    public int execute(int num1, int num2) {
        return num1-num2;
    }
}
