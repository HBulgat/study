package danli.demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Test {
    private static boolean isSameObj(Object[] singletons){
        for (int i = 1; i < singletons.length; i++) {
            if(singletons[i-1]!=singletons[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) throws InterruptedException {
        List<Singleton> list=new ArrayList<>();
        list=Collections.synchronizedList(list);
        for (int i = 0; i < 100; i++) {
            List<Singleton> finalList = list;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    finalList.add(Singleton.getInstance());
                }
            }).start();
        }
        Thread.sleep(1000);
        Object[] array = list.toArray();
//        System.out.println(array[0]);
        System.out.println(isSameObj(array));
    }
}
