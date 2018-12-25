import org.junit.Test;

public class ThreadTest {
	
	@Test
	public void test1() {
		new Thread(new RunTask()).start();
	}
	
	class RunTask implements Runnable{
		
		@Override
		public void run() {
			System.out.println("aaa");
		}
	}
	
	@Test
	public void test2() {
		for (Thread thread: Thread.getAllStackTraces().keySet()) {
			
			System.out.println(thread.getName());
		}
	}
}

