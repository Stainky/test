/**
 * Created by sj on 17/4/15.
 */
public class TestVolatile {
    public static volatile int i = 10;

    public static class Thread1 implements Runnable {

        @Override
        public void run() {
            int val = 0;
            while(val < 100000) {
                val ++;
                i ++;
            }
        }
    }
    public static class Thread2 implements Runnable {

        @Override
        public void run() {
            int j = 0;
            while(j < 100000) {
                j ++;
                i ++;
            }
        }
    }

    public synchronized void testVolatile() {
        int i = 0;
        while(i < 40) {
            i ++;
        }
        System.out.println("this is a synchonized method.");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();
        thread2.start();
        while(thread1.isAlive() || thread2.isAlive()) {

        }
        System.out.println(i);
    }
}
