import java.util.Date;

public class Test extends Date {
	
	public static void main(String[] args) {
		new Test().test();
	}
	
	public void test() {
		System.out.println(super.getClass());
		System.out.println(super.getClass().getName());

		int i = 0;
		int k = 10;
		while (k --> 0) {
			System.out.println("aa");
			i = ++i;
		}
		System.out.println(i);
	}
}