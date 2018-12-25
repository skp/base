import org.junit.Test;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class CollectionTest {
	
	@Test
	public void arrayList() {
		List l = new ArrayList();
	}
	
	@Test
	public void vectorTest() {
//		Vector
	}
	
	@Test
	public void hashMap() {
		Map m = new HashMap(17);
	}
	
	@Test
	public void concurrentHashMap() {
		Map m = new ConcurrentHashMap();
	}
	
	@Test
	public void collectionSynchronizeMethod() {
//		Collections.synchronizedMap()
	}
	
	@Test
	public void blockingQueue() {
		BlockingQueue m = new LinkedBlockingQueue(17);
	}
}
