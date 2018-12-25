import java.util.concurrent.TimeUnit;

public class InterruptTest {
	
	public static void main(String[] args) throws InterruptedException {
		RunTest rt = new RunTest();
		Thread t = new Thread(rt);
		t.start();
		TimeUnit.SECONDS.sleep(2);
		t.interrupt();
	}
}

//不同的run方法设计
class RunTest implements Runnable {
	
	@Override
	public void run() {
		run1();
	}
	
	private void run0() {
		double d = 1;
		while (!Thread.interrupted()) {
			while (d < 3000) {
				d = d + (Math.PI + Math.E) / d;
				System.out.println(d + " running");
				//接收到中断信号时,不会中断正在运行的操作,只有当操作完成后,检查中断状态时会退出
			}
		}
		System.out.println("Exit " + d);
	}
	
	//这种设计比较好,当调用阻塞操作时,会因为抛出异常退出,当不调用阻塞操作时,会因为检查中断状态而退出
	public void run1() {
		try {
			while (!Thread.interrupted()) {
				// System.out.println("sleep 5s");
				Thread.sleep(5000); //接收到中断信号时,由于while循环判断不成立退出,不抛出异常
			}
			System.out.println("Exit normal");
		} catch (Exception e) {
			System.out.println("interrupted");
		}
	}
	
	public void run5() {
		try {
			while (!Thread.interrupted()) {
				// System.out.println("sleep 5s");
				Thread.sleep(5000);//接收到中断信号时，由于抛出异常退出，模拟耗时操作
			}
			System.out.println("Exit normal");
		} catch (Exception e) {
			System.out.println("interrupted and exit");
		}
	}
	
	public void run3() {
		while (!Thread.interrupted()) {
			//接收到中断信号时,由于while循环判断不成立退出
		}
		System.out.println("interrupt normal and exit 2");
	}
	
	//此种设计不好
	public void run4() {
		while (!Thread.interrupted()) {
			try {
				TimeUnit.SECONDS.sleep(1);
				//接收到中断信号，捕获异常并清除中断状态，所以不退出,所以这种不是良好的设计方式,如果想要退出,需要在catch语句中Thread.currentThread().interrupt();
			} catch (Exception e) {
				System.out.println("Interrupte and clear interrupt status, so run continue");
		}
		}
		System.out.println("exit normal 3");
	}
	
}