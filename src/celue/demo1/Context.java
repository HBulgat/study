package celue.demo1;

public class Context {
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy=strategy;
    }
    public int executeStrategy(int num1,int num2){
        return strategy.execute(num1,num2);
    }
}
