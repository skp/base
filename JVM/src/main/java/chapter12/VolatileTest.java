package chapter12;

import java.util.Iterator;

/**
 * volatile变量自增运算测试
 * 
 * @author zzm
 */
public class VolatileTest {

    public static volatile int race = 0;
    
    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        
//        Iterator i = Thread.getAllStackTraces().keySet().iterator();
//        while (i.hasNext()) {
//            System.out.println(((Thread) i.next()).getName());
//            System.out.println(((Thread) i.next()).isAlive());
//        }
//        System.out.println(Thread.activeCount());
        // 等待所有累加线程都结束
	    while (Thread.activeCount() > 2) {
		    Thread.yield();
	    }
//        Thread.sleep(2000);
        System.out.println(race);
    }
}

