import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class MapTest {

	@Test
	public void weakHashMapTest() {
		Map<String, String> weakHashMap = new WeakHashMap<>();
		weakHashMap.put(null, "123");
	}

	@Test
	public void hashMapTest() {
		Map<String, String> hashMap = new HashMap<>(64);
		// String key = "asd";
		// int h;
		// System.out.println(Integer.toBinaryString(key.hashCode()));
		// System.out.println(Integer.toBinaryString(key.hashCode() >>> 16));
		// System.out.println(Integer.toBinaryString((h = key.hashCode()) ^ 0b10011));
		String a;
		for (int i = 0; i < 400; i++) {
			a = String.valueOf((char) i);
			System.out.println(a.hashCode());
			hashMap.put(a, "123");
		}
		//		hashMap.put(null, "123");
		//		System.out.println(hashMap.get(null));
	}

	@Test
	public void treeMapTest() {
		Map<String, String> map = new TreeMap<>();

		map.put("1", "");
		map.put("a", "");
		map.put("b", "");
		map.put("ab", "");
		map.put("aa", "");
		map.put("2", "");

		// map.keySet().stream().forEach(key -> System.out.println(key));
	}
}
