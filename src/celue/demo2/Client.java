package celue.demo2;

import java.util.HashMap;
import java.util.Map;

public class Client {
    private static Map<String,Strategy> map=new HashMap<>();
    static {
        map.put("ADD", new AddStrategy());
        map.put("SUB",new SubtractStrategy());
    }

    public static void main(String[] args) {
        Strategy strategy = map.get("ADD");
        System.out.println(strategy.execute(10,10));
    }
}
