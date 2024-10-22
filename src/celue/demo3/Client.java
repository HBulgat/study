package celue.demo3;

import java.util.HashMap;
import java.util.Map;

public class Client {
    private static Map<String,Strategy> map;
    static {
        map=new HashMap<>();
        map.put("ADD", StrategyEnum.ADD_STRATEGY);
        map.put("SUB", StrategyEnum.SUBTRACT_STRATEGY);
    }

    public static void main(String[] args) {
        Strategy strategy=map.get("ADD");
        System.out.println(strategy.execute(100,1));
    }
}
