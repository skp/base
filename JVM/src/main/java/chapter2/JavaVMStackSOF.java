package chapter2;

public class JavaVMStackSOF {
	private int stackLength = 1;
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("11" + oom.stackLength);
			throw e;
		}
	}
}
