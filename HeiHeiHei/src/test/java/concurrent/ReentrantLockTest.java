package concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	
	private ReentrantLock rLock = new ReentrantLock();
	
	void m1() {
		rLock.lock();
		int[] a = new int[5];
		System.out.println(a);
//		a[0] = 1;
//		a = [1];
		//		for (int i: [1,2,3]) {
//
//		}
	}
	
	public static void main(String[] args) {
		new ReentrantLockTest().m1();
	}
}
