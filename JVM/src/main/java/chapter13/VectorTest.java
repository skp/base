package chapter13;

import java.util.Vector;

public class VectorTest {
	
	private static Vector<Integer> vector = new Vector<Integer>();
	
	public static void main(String[] args) {
		while (true) {
			for (int i = 0; i < 10; i++) {
				vector.add(i);
			}
			
			Thread removeThread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < vector.size(); i++) {
						vector.remove(i);
					}
				}
			});
			
			Thread printThread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < vector.size(); i++) {
						System.out.println((vector.get(i)));
					}
				}
			});
			
			removeThread.start();
			printThread.start();
			
			//不要同时产生过多的线程，否则会导致操作系统假死
			while (Thread.activeCount() > 20) {
				;
			}
		}
	}
	
	/*public String concatString(String s1, String s2, String s3) {
		return s1 + s2 + s3;
	}
	
	public String concatString(String s1, String s2, String s3) {
		StringBuffer sb = new StringBuffer();
		sb.append(s1);
		sb.append(s2);
		sb.append(s3);
		return sb.toString();
	}*/
}
