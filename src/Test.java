import java.util.concurrent.CountDownLatch;

public class Test {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(5); // 声明计数器为度5个
		Thread t = new Thread() {
			public void run() {
				try {
					System.out.println("no");
				} catch (Exception e) {
					// TODO 异常处理
				} finally {
					latch.countDown(); // 这句是关键
					System.out.println("ok"); // 5个线程问都跑完后输答出
				}
			}
		};
		t.start();

	}

}
