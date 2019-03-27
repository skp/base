import org.junit.Test;

public class ThreadPoolTest {
	int poolSize = Runtime.getRuntime().availableProcessors();
	@Test
	public void test1() {
		System.out.println(poolSize);
	}
}
