package celue.demo3;

public enum StrategyEnum implements Strategy{
    ADD_STRATEGY{
        @Override
        public int execute(int num1,int num2){
            return num1+num2;
        }
    },
    SUBTRACT_STRATEGY{
        @Override
        public int execute(int num1,int num2){
            return num1-num2;
        }
    }
}
