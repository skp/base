package v1ch09.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class IteratorTest {
	
	public static void forEach() {
		Collection<String> c = new ArrayList<>();
		c.add("a");
		c.add("b");
		c.add("c");
		Iterator iter = c.iterator();
		iter.forEachRemaining(i -> System.out.println(i));
		
	}
	
	public static void main(String[] args) {
		forEach();
	}
}
