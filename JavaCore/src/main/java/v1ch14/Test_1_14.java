package v1ch14;

public class Test_1_14 {
	
	public static void main(String[] args) {
		Runnable r1 = () -> {
			
			System.out.println("a");
		};
		Runnable r2 = () -> {
			
			System.out.println("b");
		};
//		Thread.State.
		Thread.currentThread().notify();
	}
}