package danli.demo2;

import danli.demo5.Singleton;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    private static boolean isSameObj(Object[] singletons){
        for (int i = 1; i < singletons.length; i++) {
            if(singletons[i-1]!=singletons[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        List<Singleton> list=new ArrayList<>();
        list= Collections.synchronizedList(list);
        Thread[] threads=new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            List<Singleton> finalList = list;
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    finalList.add(Singleton.getInstance());
                }
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        Thread.sleep(1000);
        Object[] array = list.toArray();
//        System.out.println(array[0]);
        System.out.println(isSameObj(array));//false

    }

}
