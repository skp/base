public class Singleton {

	private Singleton() {

	}
	// 静态内部类
	public static Singleton getInstance(){
		return SingletonInner.instance;
	}

	private static class SingletonInner {
		private static final Singleton instance = new Singleton();
	}

	// 双重检查加锁 现在也不安全. DCL失效

	/*private volatile static Singleton instance;

	public static Singleton getInstance(){
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}*/
}
