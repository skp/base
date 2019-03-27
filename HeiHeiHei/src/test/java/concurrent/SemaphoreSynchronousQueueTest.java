package concurrent;

import java.util.concurrent.Semaphore;

class SemaphoreSynchronousQueue<E> {
    E item = null;
    Semaphore sync = new Semaphore(0);
    Semaphore send = new Semaphore(1);
    Semaphore recv = new Semaphore(0);
 
    public E take() throws InterruptedException {
        recv.acquire();
        E x = item;
        sync.release();
        send.release();
        return x;
    }
 
    public void put (E x) throws InterruptedException{
        send.acquire();
        item = x;
        recv.release();
        sync.acquire();
    }
}

public class SemaphoreSynchronousQueueTest {

    public static void main(String[] args) throws InterruptedException {
        final SemaphoreSynchronousQueue<String> queue = new SemaphoreSynchronousQueue<String>();
        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread start");
                try {
                    queue.put("1");
                } catch (InterruptedException e) {
                }
                System.out.println("put thread end");
            }
        });

        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread start");
                try {
                    System.out.println("take from putThread: " + queue.take());
                } catch (InterruptedException e) {
                }
                System.out.println("take thread end");
            }
        });

        putThread.start();
        Thread.sleep(1000);
        takeThread.start();
    }

}