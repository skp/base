package functional;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalDemo {

	@Test
	public void test1() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Supplier<Map<Integer, Integer>> mapSupplier = () -> list.stream().collect(Collectors.toMap(x -> x, y -> y * y));

		System.out.println(mapSupplier.get());
		Map<Integer, Integer> mapValueAdd = list.stream().collect(
				Collectors.toMap(x -> x, y -> y, (v1, v2) -> v1 + v2, mapSupplier));
		System.out.println(mapValueAdd);
	}
}
