package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch维护一个计数器,等待这个CountDownLatch的线程必须等到计数器为0时才可以继续.
 * 以下实例模拟服务器的启动,假设启动一个服务器需要初始化3个组件,当3个组件初始化完毕后,服务器才算成功启动.
 *
 * 使用CountDownLatch的关键技术点如下:
 * 1.构造CountDownLatch对象时,需要指定计数器的初始值,该值必须大于等于0,一旦对象被创建,其初始值将不能被改变.
 * 2.CountDownLatch的await方法使当前线程进入等待状态,直到计数器为0
 * 3.CountDownLatch的countDown方法使计数器减1.
 */
public class CountDownLatchTest{

	/**
	 * 初始化组件的线程
	 */
	public static class ComponentThread implements Runnable{

		CountDownLatch latch; //计数器

		int ID; //组件ID

		//构造方法
		public ComponentThread(CountDownLatch latch, int ID){
			this.latch = latch;
			this.ID = ID;
		}

		public void run(){
			//初始化组件
			System.out.println("Initializing component " + ID);
			try{
				Thread.sleep(500 * ID);
			}catch(InterruptedException e){
			}
			System.out.println("Component " + ID + " initialized! latch:" + latch);
			latch.countDown(); //将计数器减1
		}
	}

	/**
	 * 启动服务器
	 */
	public static void startServer() throws Exception{
		System.out.println("Server is starting.");
		//初始化一个初始值为3的CountDownLatch
		CountDownLatch latch = new CountDownLatch(3);
		//启动3个线程分别执行3个组件
		ExecutorService service = Executors.newCachedThreadPool();
		service.submit(new ComponentThread(latch, 1));
		service.submit(new ComponentThread(latch, 2));
		service.submit(new ComponentThread(latch, 3));
		service.shutdown();
		latch.await();//等待3个组件的初始化工作都完成
		System.out.println("Server is up!");//当所需的三个组件都完成时,Server就可以继续了
	}

	public static void main(String... args) throws Exception{
		CountDownLatchTest.startServer();
	}
}