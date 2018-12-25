package v1ch09.arrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArraylistTest {
	
	static List<String> s = new Vector<>();
	static ArrayList<String> al = new ArrayList<>();
	
	public static void a(String ss) {
		s.add(ss);
	}
	
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		for (String a : al) {
		
		}
		
		ExecutorService es = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			es.submit(new cu(i));
		}
	}
	
	static class cu implements Runnable {
		
		int i;
		
		cu(int a) {
			i = a;
		}
		
		@Override
		public void run() {
			a(i + "");
		}
	}
}
