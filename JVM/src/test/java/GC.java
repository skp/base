import org.junit.Test;

public class GC {
	
	@Test
	public void test1() {
		byte[] placeholder = new byte[64 * 1024 * 1024];
		System.gc();
	}
}
