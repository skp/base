import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	@Test
	public void test1() {
		AtomicInteger i = new AtomicInteger();
		System.out.println(Float.floatToIntBits(1.11F));
		System.out.println(Double.doubleToLongBits(1.11D));
	}
}
