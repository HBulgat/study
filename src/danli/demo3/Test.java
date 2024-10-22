package danli.demo3;

import java.io.*;


public class Test {
    private static boolean isSameObj(Object[] singletons){
        for (int i = 1; i < singletons.length; i++) {
            if(singletons[i-1]!=singletons[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
//        List<Singleton> list=new ArrayList<>();
//        list= Collections.synchronizedList(list);
//        int n=100000;
//        Thread[] threads=new Thread[n];
//        for (int i = 0; i < n; i++) {
//            List<Singleton> finalList = list;
//            threads[i]=new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    finalList.add(Singleton.getInstance());
//                }
//            });
//        }
//        for (int i = 0; i < threads.length; i++) {
//            threads[i].start();
//        }
//        Thread.sleep(1000);
//        Object[] array = list.toArray();
////        System.out.println(array[0]);
//        System.out.println(isSameObj(array));//false
        test();
    }
    public static void test() throws Exception {
        Singleton instance1= Singleton.getInstance();
        File file=new File("data.txt");
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(instance1);
        oos.close();
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
        Object o = ois.readObject();
        ois.close();
        System.out.println(o==instance1);
//        System.out.println(((Singleton)o));
    }
}
